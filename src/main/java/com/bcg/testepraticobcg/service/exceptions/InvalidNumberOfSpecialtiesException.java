package com.bcg.testepraticobcg.service.exceptions;


public class InvalidNumberOfSpecialtiesException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidNumberOfSpecialtiesException(String msg) {
        super(msg);
    }

}