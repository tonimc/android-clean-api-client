package xyz.tonimartinez.cleanandroidapiclient.domain.executor;

/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ExecutorProvider {

    private static Executor mExecutor;
    private static MainThread mMainThread;


    public static Executor provideExecutor() {
        if ( mExecutor == null ) {
            mExecutor = new ThreadExecutor();
        }
        return mExecutor;
    }

    public static MainThread provideMainThread() {
        if ( mMainThread == null ) {
            mMainThread = new UIThread();
        }
        return mMainThread;
    }
}
