package com.jdbl.Jbdl_CaseStudy3.service;

import com.jdbl.Jbdl_CaseStudy3.entity.Author;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.requests.AuthorRequest;
import com.jdbl.Jbdl_CaseStudy3.requests.BookRequest;

import java.util.List;

public interface authorService {

    Author findByEmail(String email);
    Author createAuthor(Author author);
}
