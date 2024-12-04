package org.example.exception;

public class RequestNotAuthroizedException extends Exception{
    public RequestNotAuthroizedException(String massage){
        super(massage);
    }
}
