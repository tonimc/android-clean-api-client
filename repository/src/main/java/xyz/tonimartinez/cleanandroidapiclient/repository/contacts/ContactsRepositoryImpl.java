package xyz.tonimartinez.cleanandroidapiclient.repository.contacts;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDummyDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.repository.ContactsRepository;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource.ContactsApiDataSource;
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.DatasourceErrorException;

/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactsRepositoryImpl implements ContactsRepository {

    ContactsApiDataSource contactsApiDataSource;

    public ContactsRepositoryImpl() {
        this.contactsApiDataSource = new ContactsApiDataSourceImpl();
        //this.contactsApiDataSource = new ContactsApiDummyDataSourceImpl();
    }

    @Override
    public Contact getContact(String id) throws RepositoryErrorException {
        try {
            return contactsApiDataSource.getContact(id);
        } catch (DatasourceErrorException e) {
            throw new RepositoryErrorException(e);
        }
    }

    public List<Contact> getContactsList() throws RepositoryErrorException {
        try {
            return contactsApiDataSource.getContactsList();
        } catch (DatasourceErrorException e) {
            throw new RepositoryErrorException(e);
        }
    }

    @Override
    public Contact addContact(Contact contact) throws RepositoryErrorException {
        try {
            return contactsApiDataSource.addContact(contact);
        } catch (DatasourceErrorException e) {
            throw new RepositoryErrorException(e);
        }
    }

    @Override
    public Contact editContact(Contact contact) throws RepositoryErrorException {
        try {
            return contactsApiDataSource.editContact(contact);
        } catch (DatasourceErrorException e) {
            throw new RepositoryErrorException(e);
        }
    }

    @Override
    public boolean deleleteContact(String id) throws RepositoryErrorException {
        try {
            return contactsApiDataSource.deleteContact(id);
        } catch (DatasourceErrorException e) {
            throw new RepositoryErrorException(e);
        }
    }

}
