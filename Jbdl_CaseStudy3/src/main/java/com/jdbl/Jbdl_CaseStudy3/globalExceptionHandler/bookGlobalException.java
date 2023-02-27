package com.jdbl.Jbdl_CaseStudy3.globalExceptionHandler;

import com.jdbl.Jbdl_CaseStudy3.exception.bookException;
import com.jdbl.Jbdl_CaseStudy3.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.TransactionalException;

@ControllerAdvice
public class bookGlobalException {

    @ExceptionHandler(bookException.class)
    public ResponseEntity<APIResponse> bookException() throws bookException {
        APIResponse apiResponse=APIResponse.builder().success(true).message("Unable to load the book details")
                .httpStatus(HttpStatus.NOT_FOUND).build();
        return  ResponseEntity.ok(apiResponse);
    }

    @ExceptionHandler(TransactionalException.class)
    public ResponseEntity<APIResponse> TransactionException()
    {
      APIResponse apiResponse=APIResponse.builder().success(true).message("Transaction has issue, Failed. Try again.").httpStatus(HttpStatus.BAD_GATEWAY).build();
        return ResponseEntity.ok(apiResponse);
    }
}
