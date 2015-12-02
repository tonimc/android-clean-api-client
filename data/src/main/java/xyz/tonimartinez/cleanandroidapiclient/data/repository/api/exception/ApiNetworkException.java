package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.exception;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ApiNetworkException extends Exception {
    public ApiNetworkException() {
    }

    public ApiNetworkException(String message) {
        super(message);
    }

    public ApiNetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiNetworkException(Throwable cause) {
        super(cause);
    }

    public ApiNetworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
