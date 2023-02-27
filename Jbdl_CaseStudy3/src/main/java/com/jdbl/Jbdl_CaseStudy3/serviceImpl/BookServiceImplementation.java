package com.jdbl.Jbdl_CaseStudy3.serviceImpl;

import com.jdbl.Jbdl_CaseStudy3.Enum.BookFilterByType;
import com.jdbl.Jbdl_CaseStudy3.Enum.BookSearchOperationType;
import com.jdbl.Jbdl_CaseStudy3.entity.Author;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.repository.AuthorRepository;
import com.jdbl.Jbdl_CaseStudy3.repository.BookRepository;
import com.jdbl.Jbdl_CaseStudy3.requests.BookRequest;
import com.jdbl.Jbdl_CaseStudy3.response.BookSearchResponse;
import com.jdbl.Jbdl_CaseStudy3.service.BookService;
import com.jdbl.Jbdl_CaseStudy3.service.authorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private authorService authService;

    @Override
    public Book createBook(BookRequest bookRequest){
        int uuid= new Random().nextInt();
        Book book=bookRequest.toBook();
        book.setId(uuid);
        Author author=book.getAuthor();
        Author getAuthorFromDataBase=authService.findByEmail(author.getEmail());
        if(getAuthorFromDataBase == null)
        {
            getAuthorFromDataBase=authService.createAuthor(author);
        }
        book.setAuthor(getAuthorFromDataBase);
        return bookRepository.save(book);
    }

    @Override
    public Book saveBook(Book book) {
        Book saveBook=new Book();
        int uuid= new Random().nextInt();
        saveBook.setId(uuid);
        saveBook=bookRepository.save(book);
        return saveBook;
    }

    @Override
    public Book findById(Integer id) throws bookException {
        return bookRepository.findById(id).orElseThrow(() -> new bookException("Requested Book id is not available"));
    }

    @Override
    public List<Book> findAll() {
        List<Book> listAllBook=bookRepository.findAll();
        return listAllBook;
    }

    @Override
    public Book updateBookById(Integer id) {
        Book getBookFirst=bookRepository.findById(id).get();
        Book updateBook=new Book();
        updateBook= bookRepository.save(getBookFirst);
        return updateBook;
    }

    @Override
    public void delete() {
        bookRepository.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
        System.out.print(id+" is deleted successfully.");
    }

    @Override
    public List<Book> find(BookFilterByType filterType, String value) {
        switch (filterType)
        {
            case NAME:
                return bookRepository.findByName(value);
            case COST:
                return bookRepository.findByCost(Integer.parseInt(value));
            case AUTHOR_NAME:
                return  bookRepository.findByAuthorName(value);
            case ID:
                return bookRepository.findAllById(new ArrayList<Integer>(Integer.parseInt(value)));
            case BookGenre:
                return bookRepository.findByGenre(value);
        }
        return null;
    }

    @Override
    public List<BookSearchResponse> findFilteredByBooks(BookFilterByType filterType, String value) {
            return find(filterType,value).stream().map(book -> book.toBookSearchResponse()).collect(Collectors.toList());
    }

    @Override
    public List<BookSearchResponse> findRobustFilteredBooks(BookFilterByType bookFilterType, String value, BookSearchOperationType bookSearchOperationType) {
        return null;
    }


}
