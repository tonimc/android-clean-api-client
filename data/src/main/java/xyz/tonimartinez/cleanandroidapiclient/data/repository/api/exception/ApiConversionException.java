package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.exception;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ApiConversionException extends Exception {
    public ApiConversionException() {
    }

    public ApiConversionException(String message) {
        super(message);
    }

    public ApiConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiConversionException(Throwable cause) {
        super(cause);
    }

    public ApiConversionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
