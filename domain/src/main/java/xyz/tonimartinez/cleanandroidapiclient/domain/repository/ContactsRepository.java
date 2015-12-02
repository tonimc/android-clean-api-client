package xyz.tonimartinez.cleanandroidapiclient.domain.repository;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ContactsRepository {
    Contact getContact(String hash);
    List<Contact> getContactsList();
}
