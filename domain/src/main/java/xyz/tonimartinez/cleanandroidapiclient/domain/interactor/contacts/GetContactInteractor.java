package xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts;

import xyz.tonimartinez.cleanandroidapiclient.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.Executor;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.Interactor;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.MainThread;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.ErrorImpl;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.repository.ContactsRepository;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class GetContactInteractor implements Interactor, GetContact {

    private Executor executor;
    private MainThread mainThread;

    private GetContactCallback callback;
    private String contactId;

    private ContactsRepository contactsRepository;

    public GetContactInteractor(Executor executor, MainThread mainThread, ContactsRepository contactsRepository) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void run() {
        try {
            Contact contact = contactsRepository.getContact(contactId);
            nofitySuccess(contact);
        } catch (RepositoryErrorException e) {
            notifyError(new ErrorImpl("Error when the app try to get the contact info"));
        }
    }

    @Override
    public void execute(GetContactCallback callback, String contactId) {
        validateArguments(callback, contactId);
        this.callback = callback;
        this.contactId = contactId;
        executor.run(this);
    }

    private void validateArguments(GetContactCallback callback, String contactId) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback parameter can't be null");
        }
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact id parameter can't be null or empty");
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

    protected void nofitySuccess(final Contact contact) {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(contact);
            }
        });
    }
}
