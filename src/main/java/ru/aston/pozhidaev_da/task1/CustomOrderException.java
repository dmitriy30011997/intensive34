package ru.aston.pozhidaev_da.task1;

public class CustomOrderException extends Exception {
    private int errorCode;
    private String errorMessage;

    public CustomOrderException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
