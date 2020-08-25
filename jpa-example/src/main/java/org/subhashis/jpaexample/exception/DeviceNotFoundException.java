package org.subhashis.jpaexample.exception;

import org.springframework.http.HttpStatus;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException(String msg) {
        super("Device not found exception occurred. " + msg);
    }

    public DeviceNotFoundException(Throwable cause) {
        super(cause);
    }

    public DeviceNotFoundException(String msg, Throwable cause) {
        super(msg,cause);
    }
}