package xyz.tonimartinez.cleanandroidapiclient.domain.exception;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class RepositoryErrorException extends Exception {
    public RepositoryErrorException() {
    }

    public RepositoryErrorException(String message) {
        super(message);
    }

    public RepositoryErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryErrorException(Throwable cause) {
        super(cause);
    }

    public RepositoryErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
