package com.jdbl.Jbdl_CaseStudy3.serviceImpl;

import com.jdbl.Jbdl_CaseStudy3.entity.Author;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.repository.AuthorRepository;
import com.jdbl.Jbdl_CaseStudy3.service.authorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class authorServiceImpl implements authorService {

    @Autowired
    private AuthorRepository authRepos;

    @Override
    public Author findByEmail(String email){
        return authRepos.findByEmail(email);
    }

    @Override
    public Author createAuthor(Author author) {
        authRepos.save(author);
        return author;
    }
}