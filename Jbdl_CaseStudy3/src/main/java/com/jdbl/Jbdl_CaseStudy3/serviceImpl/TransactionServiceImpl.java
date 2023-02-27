package com.jdbl.Jbdl_CaseStudy3.serviceImpl;

import com.jdbl.Jbdl_CaseStudy3.Enum.TransactionsType;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import com.jdbl.Jbdl_CaseStudy3.entity.Transactions;
import com.jdbl.Jbdl_CaseStudy3.exception.TransactionServiceException;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.repository.TransactionRepository;
import com.jdbl.Jbdl_CaseStudy3.service.BookService;
import com.jdbl.Jbdl_CaseStudy3.service.StudentServeInterf;
import com.jdbl.Jbdl_CaseStudy3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentServeInterf studentService;

    @Autowired
    private TransactionRepository tranxRepos;

    @Value("${book.permissibleDays}")
    int max_days_allowed;

    @Override
    public String issueTranx(int studentId, int bookId) throws TransactionServiceException, bookException {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new TransactionServiceException("student data is not present");
        }
        Book book = bookService.findById(bookId);
        if (book == null || book.getStudent() != null) {
            throw new TransactionServiceException("Book not available in the libarary");
        }
        Transactions tranx = Transactions.builder().id(Integer.parseInt(UUID.randomUUID().toString())).transactionsType(TransactionsType.ISSUE).payment(0).book(book).student(student).build();
        tranxRepos.save(tranx);
        book.setStudent(student);
        bookService.saveBook(book);
        return String.valueOf(tranx.getId());
    }

    @Override
    public String returnTranx(int studentId, int bookId) throws bookException, TransactionServiceException {

        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new TransactionServiceException("Student not present in the library");
        }
        Book book = bookService.findById(bookId);
        if (book == null) {
            throw new TransactionServiceException("Book not present in the library");
        }
        if (book.getStudent() == null || book.getStudent().getId() != studentId) {
            throw new TransactionServiceException("Book Not Issued to the given Student");
        }

       Transactions issueTranx= (Transactions) tranxRepos.findTopByBookAndStudentAndTransactionsTypeOrderByIdDesc(book,student,TransactionsType.ISSUE);

        Transactions tranx=Transactions.builder()
                .externalId(UUID.randomUUID().toString())
                .transactionsType(TransactionsType.RETURN)
                .payment(calculateFine(issueTranx))
                .book(book)
                .student(student)
                .build();




        return null;
    }

    private double calculateFine(Transactions tranx)
    {

        long issueTime=tranx.getCreatedTime().getTime();
        long returnedDate=System.currentTimeMillis();

        long diff=returnedDate-issueTime;
        long dayPassed= TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);

        if(dayPassed > max_days_allowed)
        {
            return (dayPassed-max_days_allowed)*10.0;
        }

        return 0.0;
    }
}
