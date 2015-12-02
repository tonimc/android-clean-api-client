package xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ContactsDummyDataSource {
    Contact getContact(String id);
    List<Contact> getContactsList();
    Contact addContact(Contact contact);
    Contact editContact(Contact contact);
    boolean deleteContact(Contact contact);
}
