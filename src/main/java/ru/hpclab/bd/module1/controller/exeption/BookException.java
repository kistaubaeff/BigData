package ru.hpclab.bd.module1.controller.exeption;

/**
 * Generic exception related to users resource.
 */
public class BookException extends RuntimeException {

    /**
     * Builds new UserException from the given message.
     * @param message exception message
     */
    public BookException(final String message) {
        super(message);
    }
}
