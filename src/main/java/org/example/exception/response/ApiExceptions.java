package org.example.exception.response;

public class ApiExceptions extends RuntimeException {
    private int code;
    private String massage;

    public ApiExceptions(String message, int code, String status) {
        super(message);
        this.code = code;
        this.massage = status;
    }

    public int getCode() {
        return code;
    }

    public String getMassage() {
        return massage;
    }

}
