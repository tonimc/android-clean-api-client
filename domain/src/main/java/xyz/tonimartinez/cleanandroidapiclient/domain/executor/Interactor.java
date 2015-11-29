package xyz.tonimartinez.cleanandroidapiclient.domain.executor;

/**
 * Common interface to every Interactor declared in the application. This interface represents a
 * execution unit for different use cases.
 *
 * By convention every interactor implementation will return the result using a Callback. That
 * callback should be executed over the UI thread.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface Interactor {
    void run();
}
