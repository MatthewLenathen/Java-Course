package com.sg.classroster.service;

public class ClassRosterDuplicateIdException extends RuntimeException {
    public ClassRosterDuplicateIdException(String message) {
        super(message);
    }

    public ClassRosterDuplicateIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
