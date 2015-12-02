package xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.RepositoryErrorException;

/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ContactsApiDataSource {
    Contact getContact(String id) throws RepositoryErrorException;
    List<Contact> getContactsList() throws RepositoryErrorException;
    Contact addContact(Contact contact) throws RepositoryErrorException;
    boolean deleteContact(Contact contact) throws RepositoryErrorException;
}
