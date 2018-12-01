package com.promauto.wes.exceptions;

public class CModuleNotFoundException extends Exception {
    public CModuleNotFoundException(String id) {
        super(id);
    }
}
