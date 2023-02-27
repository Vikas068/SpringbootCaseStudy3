package com.jdbl.Jbdl_CaseStudy3.requests;

import com.jdbl.Jbdl_CaseStudy3.Enum.BookGenre;
import com.jdbl.Jbdl_CaseStudy3.entity.Author;
import com.jdbl.Jbdl_CaseStudy3.entity.Book;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class BookRequest {
    @NotBlank
    private String name;
    @Positive
    private String cost;
    @NotBlank
    private String isbn;
    @NotNull
    private BookGenre genre;

    @NotNull
    private int availableBooks;
    @NotNull
    private Author author;


    public Book toBook() {
        return Book.builder()
                .cost(Integer.parseInt(cost))
                .genre(genre)
                .name(name)
                .author(author)
                .isbn(isbn)
                .availableBooks(availableBooks)
                .build();
    }

}
