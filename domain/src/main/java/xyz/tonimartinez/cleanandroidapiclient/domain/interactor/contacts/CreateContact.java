package xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public interface CreateContact {

    interface CreateContactCallback {
        void onSuccess(Contact contact);
        void onFailure(Error error);
    }

    void execute(Contact contact, CreateContactCallback callback);
}
