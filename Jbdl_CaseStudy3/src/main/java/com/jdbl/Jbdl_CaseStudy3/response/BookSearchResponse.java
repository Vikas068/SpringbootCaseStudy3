package com.jdbl.Jbdl_CaseStudy3.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jdbl.Jbdl_CaseStudy3.Enum.BookGenre;
import com.jdbl.Jbdl_CaseStudy3.entity.Author;
import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Builder
public class BookSearchResponse {

    private int id;

    private String name;

    private int cost;

    private String isbn;

    private BookGenre genre;

    private Student student;

    @JsonIgnoreProperties({"bookList"})
    private Author author;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
