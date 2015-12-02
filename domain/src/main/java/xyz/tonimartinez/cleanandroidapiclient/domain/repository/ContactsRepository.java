package xyz.tonimartinez.cleanandroidapiclient.domain.repository;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.exception.RepositoryErrorException;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ContactsRepository {
    Contact getContact(String id) throws RepositoryErrorException;
    List<Contact> getContactsList() throws RepositoryErrorException;
    Contact addContact(Contact contact) throws RepositoryErrorException;
    Contact editContact(Contact contact) throws RepositoryErrorException;
    boolean deleleteContact(String id) throws RepositoryErrorException;
}
