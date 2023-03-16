package edu.msudenver.exceptions;

public class GamerTagAlreadyInUseException extends RuntimeException {

    public GamerTagAlreadyInUseException(String message) {
        super(message);
    }
}
