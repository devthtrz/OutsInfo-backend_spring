package com.promauto.wes.exceptions;

public class CProductNotFoundException extends Throwable {
    public CProductNotFoundException(String name) {
        super(name);
    }
}
