package com.jdbl.Jbdl_CaseStudy3.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jdbl.Jbdl_CaseStudy3.Enum.BookGenre;
import com.jdbl.Jbdl_CaseStudy3.response.BookSearchResponse;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="book")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int cost;
    private String isbn;
    @ManyToOne
    //Join col, It is Bi directional process, No need to write seperate query to get all books student having.
            //automatically JoinColoumn will do it for us by taking student id.
    @JoinColumn
    private Student student;
    @ManyToOne
    @JsonIgnoreProperties({"bookList","country","email"})
    private Author author;

    @CreationTimestamp
    private Date CreatedatTime;

    @UpdateTimestamp
    private Date UpdateTime;
    @Enumerated(value=EnumType.STRING)
    private BookGenre genre;

    private int availableBooks;

    @OneToMany(mappedBy = "book", fetch=FetchType.LAZY)
    private List<Transactions> tranxList;
    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
    public BookSearchResponse toBookSearchResponse() {

        return BookSearchResponse.builder()
                .id(id)
                .name(name)
                .isbn(isbn)
                .cost(cost)
                .genre(genre)
                .author(author)
                .student(student)
                .createdOn(createdOn)
                .updatedOn(updatedOn)
                .build();
    }

}
