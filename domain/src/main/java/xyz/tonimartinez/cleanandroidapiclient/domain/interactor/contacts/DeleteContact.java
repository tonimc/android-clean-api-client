package xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public interface DeleteContact {

    interface DeleteContactCallback {
        void onSuccess(boolean result);
        void onFailure(Error error);
    }

    void execute(DeleteContactCallback callback);
}
