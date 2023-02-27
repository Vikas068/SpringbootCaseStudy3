package com.jdbl.Jbdl_CaseStudy3.requests;

import com.jdbl.Jbdl_CaseStudy3.entity.Author;
import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AuthorRequest {
    @NotNull
    private String name;
    @NotNull
    private String country;
    @NotNull
    private int age;
    @NotNull
    private String mobile;
    @Column(unique = true)
    @NotNull
    private String email;

    public Author authorStatus() {

        return Author.builder()
                .age(age)
                .country(country)
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
