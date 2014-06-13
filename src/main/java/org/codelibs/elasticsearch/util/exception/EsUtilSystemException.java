package org.codelibs.elasticsearch.util.exception;

public class EsUtilSystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EsUtilSystemException(final String message) {
        super(message);
    }

    public EsUtilSystemException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
