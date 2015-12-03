package xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface GetContactsList {

    interface GetContactsListCallback {
        void onSuccess(List<Contact> list);
        void onFailure(Error error);
    }

    void execute(GetContactsListCallback callback);
}
