package xyz.tonimartinez.cleanandroidapiclient.ui.tools;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class Navigator {

    private final AppCompatActivity activity;

    private Navigator(AppCompatActivity activity) {
        this.activity = activity;
    }

    public static Navigator with(@NonNull AppCompatActivity activity) {
        return new Navigator(activity);
    }

    private Intent setDefaultsFlags(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        return intent;
    }

    private void startActivity(Intent intent) {
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    public void openContactDetailActivity() {
        //Intent intent = LoginActivity.getLaunchIntent(activity);
        //startActivity(intent);
    }

}
