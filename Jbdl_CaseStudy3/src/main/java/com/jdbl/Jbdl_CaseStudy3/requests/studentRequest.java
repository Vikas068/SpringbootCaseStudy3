package com.jdbl.Jbdl_CaseStudy3.requests;

import com.jdbl.Jbdl_CaseStudy3.Enum.AccontStatus;
import com.jdbl.Jbdl_CaseStudy3.entity.Student;
import jdk.jfr.BooleanFlag;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class studentRequest {

    @NotNull
    private String name;
    @Column(unique = true)
    private String email;
    @NumberFormat
    private String contact;
    private String address;


    public Student studentStatus() {
        return  Student.builder().name(name)
                .email(email)
                .contact(contact)
                .address(address)
                .build();
    }
}
