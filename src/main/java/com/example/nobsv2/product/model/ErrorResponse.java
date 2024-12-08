package com.example.nobsv2.product.model;

public class ErrorResponse {

    private final String error;

    public String getError() {
        return error;
    }

    public ErrorResponse(String error) {
        this.error = error;
    }
}