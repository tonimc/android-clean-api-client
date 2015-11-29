package xyz.tonimartinez.cleanandroidapiclient.domain.executor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the Interactor out of the UI thread.
 *
 * Use this class to execute an Interactor.
 *
 * This is just a sample implementation of how a Interactor/Executor environment can be
 * implemented.
 * Ideally interactors should not know about Executor or MainThread dependency. Interactors client
 * code should get a Executor instance to execute interactors.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface Executor {

    void run(final Interactor interactor);
}

