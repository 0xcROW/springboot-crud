package com.example.nobsv2.exceptions;

public enum ErrorMessages {

    PRODUCT_NOT_FOUND("Product not found"),
    NAME_REQUIRED("Name cannot be empty"),
    DESCRIPTION_LENGTH("Description must have more than 20 characters"),
    PRICE_CANNOT_BE_NEGATIVE("Price cannot be negative");
    //Add here the error messages

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
