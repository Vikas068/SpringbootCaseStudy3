package com.jdbl.Jbdl_CaseStudy3.repository;

import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book>  findByName(String name);
    List<Book>  findByAuthorName(String authorName);
    List<Book>  findByGenre(String genreName);
    List<Book> findByCost(int cost);




}
