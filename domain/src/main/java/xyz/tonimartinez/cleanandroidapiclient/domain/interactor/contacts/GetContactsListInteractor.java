package xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.Executor;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.Interactor;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.MainThread;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.ErrorImpl;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;
import xyz.tonimartinez.cleanandroidapiclient.domain.repository.ContactsRepository;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class GetContactsListInteractor implements Interactor, GetContactsList {

    private Executor executor;
    private MainThread mainThread;

    private GetContactsListCallback callback;

    private ContactsRepository contactsRepository;

    public GetContactsListInteractor(Executor executor, MainThread mainThread, ContactsRepository contactsRepository) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void run() {
        try {
            List<Contact> list = contactsRepository.getContactsList();
            nofitySuccess(list);
        } catch (RepositoryErrorException e) {
            notifyError(new ErrorImpl("Error when the app try to get the contact list"));
        }
    }

    @Override
    public void execute(GetContactsListCallback callback) {
        validateArguments(callback);
        this.callback = callback;
        executor.run(this);
    }

    private void validateArguments(GetContactsListCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback parameter can't be null");
        }
    }

    protected void notifyError(final Error error) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onFailure(error);
            }
        });
    }

    protected void nofitySuccess(final List<Contact> list) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(list);
            }
        });
    }
}
