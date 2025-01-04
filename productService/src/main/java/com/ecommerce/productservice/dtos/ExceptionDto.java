package com.ecommerce.productservice.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.http.HttpStatus;

public class ExceptionDto {
    private HttpStatus errorCode;
    private String message;

    public ExceptionDto(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }
    public HttpStatus getErrorCode() {
        return errorCode;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
