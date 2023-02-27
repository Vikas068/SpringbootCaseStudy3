package com.jdbl.Jbdl_CaseStudy3.controller;

import com.jdbl.Jbdl_CaseStudy3.Enum.BookFilterByType;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.requests.BookRequest;
import com.jdbl.Jbdl_CaseStudy3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //saveBook
    @PostMapping("/save")
    public ResponseEntity saveBook(@Valid @RequestBody BookRequest bookRequest) throws bookException {
        bookService.createBook(bookRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    //findbooks
    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam("filter") BookFilterByType filterByType, @RequestParam("value") String value) {
        return bookService.find(filterByType,value);
    }



    //

}
