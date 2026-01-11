package com.AbAmAk.Pompa.entity.exceptions;

public class UniqueUserEmailException extends RuntimeException {
    public UniqueUserEmailException(String message) {
        super(message);
    }
}
