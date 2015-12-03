package xyz.tonimartinez.cleanandroidapiclient.ui.presenter;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.di.RepositoryModule;
import xyz.tonimartinez.cleanandroidapiclient.domain.executor.ExecutorProvider;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.Error;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts.GetContactsList;
import xyz.tonimartinez.cleanandroidapiclient.domain.interactor.contacts.GetContactsListInteractor;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.repository.ContactsRepository;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.mapper.MapperContactDTO;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view.ContactListView;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactListPresenter {

    private ContactListView view;


    private GetContactsList getContactsListInteractor;
    private MapperContactDTO mapperContactDTO;

    public ContactListPresenter(ContactListView view) {
        this.view = view;
        this.mapperContactDTO = new MapperContactDTO();

        ContactsRepository contactsRepository = RepositoryModule.provideContactsRepository();
        this.getContactsListInteractor = new GetContactsListInteractor(ExecutorProvider.provideExecutor(),
                ExecutorProvider.provideMainThread(),
                contactsRepository);
    }

    public void initialize() {

    }

    public void resume() {

    }

    public void pause() {
    }

    public void getContactList() {
        view.showLoading();

        getContactsListInteractor.execute(new GetContactsList.GetContactsListCallback() {
            @Override
            public void onSuccess(List<Contact> list) {
                view.renderContactList(mapperContactDTO.mapperList(list));
                view.hideLoading();
            }

            @Override
            public void onFailure(Error error) {
                view.showError(error.getText());
                view.hideLoading();
            }
        });
    }


}
