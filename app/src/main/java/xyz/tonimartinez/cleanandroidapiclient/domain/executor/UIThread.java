package xyz.tonimartinez.cleanandroidapiclient.domain.executor;

import android.os.Handler;
import android.os.Looper;



/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
class UIThread implements MainThread {

    private Handler handler;

    UIThread() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}

