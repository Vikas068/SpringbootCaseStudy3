package com.jdbl.Jbdl_CaseStudy3.repository;

import com.jdbl.Jbdl_CaseStudy3.Enum.TransactionsType;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import com.jdbl.Jbdl_CaseStudy3.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions,Integer> {

    Transactions findTopByBookAndStudentAndTransactionsTypeOrderByIdDesc(Book book, Student student,
                                                                       TransactionsType issue);
}
