package xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface GetContact {

    interface GetContactCallback {
        void onSuccess(Contact contact);
        void onFailure(Error error);
    }

    void execute(GetContactCallback callback, String contactId);

}
