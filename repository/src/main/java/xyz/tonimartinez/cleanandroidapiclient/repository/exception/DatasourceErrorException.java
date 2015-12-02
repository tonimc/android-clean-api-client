package xyz.tonimartinez.cleanandroidapiclient.repository.exception;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class DatasourceErrorException extends Exception {

    public DatasourceErrorException() {
    }

    public DatasourceErrorException(String message) {
        super(message);
    }

    public DatasourceErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatasourceErrorException(Throwable cause) {
        super(cause);
    }

    public DatasourceErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
