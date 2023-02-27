package com.jdbl.Jbdl_CaseStudy3.entity;

import com.jdbl.Jbdl_CaseStudy3.Enum.TransactionsType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalId;

    @Enumerated
    private TransactionsType transactionsType;

    private double payment;
    @ManyToOne
    private Book book;
    @ManyToOne
    private Student student;

    @CreationTimestamp
    private Date createdTime;




}
