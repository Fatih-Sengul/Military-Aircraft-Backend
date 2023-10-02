package com.aircraftdemo1.aircraftdemo1.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
//
//    public ResourceNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public static ResourceNotFoundException fromChangeSetPersisterNotFoundException(String message) {
//        return new ResourceNotFoundException(message);
//    }
}

