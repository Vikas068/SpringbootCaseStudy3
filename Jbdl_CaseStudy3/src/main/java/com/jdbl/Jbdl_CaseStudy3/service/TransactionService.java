package com.jdbl.Jbdl_CaseStudy3.service;

import com.jdbl.Jbdl_CaseStudy3.exception.TransactionServiceException;
import com.jdbl.Jbdl_CaseStudy3.exception.bookException;

public interface TransactionService {

    String issueTranx(int studentId, int bookId) throws TransactionServiceException, bookException;
    String returnTranx(int studentId,int bookId) throws bookException, TransactionServiceException;
}
