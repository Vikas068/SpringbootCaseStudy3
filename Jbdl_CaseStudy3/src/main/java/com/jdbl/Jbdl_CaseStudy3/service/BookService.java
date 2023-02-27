package com.jdbl.Jbdl_CaseStudy3.service;

import com.jdbl.Jbdl_CaseStudy3.Enum.BookFilterByType;
import com.jdbl.Jbdl_CaseStudy3.Enum.BookSearchOperationType;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.requests.BookRequest;
import com.jdbl.Jbdl_CaseStudy3.response.BookSearchResponse;

import java.util.List;

public interface BookService {

    //create,save,findbyid,find,update,delete
     Book createBook(BookRequest bookRequest);
     Book saveBook(Book book);
     Book findById(Integer id) throws bookException;
     List<Book> findAll();
     Book updateBookById(Integer id);
     void delete();
     void deleteById(int id);
     List<Book> find(BookFilterByType bookFilterByType,String value);

     List<BookSearchResponse> findFilteredByBooks(BookFilterByType filterType, String value);

     List<BookSearchResponse> findRobustFilteredBooks(BookFilterByType bookFilterType, String value,
                                                         BookSearchOperationType bookSearchOperationType);

}
