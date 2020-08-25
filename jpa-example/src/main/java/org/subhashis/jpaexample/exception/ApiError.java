package org.subhashis.jpaexample.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiError(HttpStatus status, String msg) {
        this();
        this.status = status;
        this.message = "Device not found exception occurred. " + msg;
    }

    public ApiError(HttpStatus status, Throwable cause) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = cause.getLocalizedMessage();
    }

    public ApiError(HttpStatus status, String msg, Throwable cause) {
        this();
        this.status = status;
        this.message = msg;
        this.debugMessage = cause.getLocalizedMessage();
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}