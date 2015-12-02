package xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.DatasourceErrorException;

/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ContactsApiDataSource {
    Contact getContact(String id) throws DatasourceErrorException;
    List<Contact> getContactsList() throws DatasourceErrorException;
    Contact addContact(Contact contact) throws DatasourceErrorException;
    Contact editContact(Contact contact) throws DatasourceErrorException;
    boolean deleteContact(String id) throws DatasourceErrorException;
}
