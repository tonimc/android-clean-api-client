package xyz.tonimartinez.cleanandroidapiclient.ui.presenter;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.di.RepositoryModule;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.ExecutorProvider;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts.GetContact;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts.GetContactInteractor;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts.GetContactsList;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts.GetContactsListInteractor;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.repository.ContactsRepository;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.mapper.MapperContactDTO;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view.ContactDetailView;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view.ContactListView;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactDetailPresenter {

    private ContactDetailView view;


    private GetContact getContact;
    private MapperContactDTO mapperContactDTO;

    public ContactDetailPresenter(ContactDetailView view) {
        this.view = view;
        this.mapperContactDTO = new MapperContactDTO();

        ContactsRepository contactsRepository = RepositoryModule.provideContactsRepository();
        this.getContact = new GetContactInteractor(ExecutorProvider.provideExecutor(),
                ExecutorProvider.provideMainThread(),
                contactsRepository) {
        };
    }

    public void initialize() {
    }

    public void resume() {

    }

    public void pause() {
    }

    public void getContact(String id) {
        view.showLoading();

        getContact.execute(new GetContact.GetContactCallback() {
            @Override
            public void onSuccess(Contact contact) {
                view.renderContact(mapperContactDTO.mapper(contact));
                view.hideLoading();
            }

            @Override
            public void onFailure(Error error) {
                view.showError(error.getText());
                view.hideLoading();
            }
        }, id);
    }


}
