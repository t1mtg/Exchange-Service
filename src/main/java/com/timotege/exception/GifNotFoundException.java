package com.timotege.exception;

public class GifNotFoundException extends RuntimeException{
    public GifNotFoundException() {
        super("GIF not found.");
    }
}
