package com.timotege.exception;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException() {
        super("Currency not found.");
    }
}
