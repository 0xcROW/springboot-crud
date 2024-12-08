package com.example.nobsv2.exceptions;

public enum ErrorMessages {

    PRODUCT_NOT_FOUND("Product Not Found");
    //Add here the error messages

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
