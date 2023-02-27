package com.jdbl.Jbdl_CaseStudy3.entity;

import com.jdbl.Jbdl_CaseStudy3.Enum.AccontStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true,nullable = false)
    private String contact;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private AccontStatus accStatus;

    @OneToMany(mappedBy = "student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    private List<Transactions> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updateOn;

}
