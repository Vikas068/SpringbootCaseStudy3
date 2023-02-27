package com.jdbl.Jbdl_CaseStudy3.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class APIResponse {

    private String message;
    private HttpStatus httpStatus;
    private boolean success;


}
