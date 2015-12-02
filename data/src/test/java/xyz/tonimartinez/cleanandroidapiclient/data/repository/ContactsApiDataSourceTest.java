package xyz.tonimartinez.cleanandroidapiclient.data.repository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Location;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Picture;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource.ContactsApiDataSource;
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.RepositoryErrorException;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactsApiDataSourceTest {

    private ContactsApiDataSource contactsDummyDataSource;

    @Before
    public void setUp() {
        contactsDummyDataSource = new ContactsApiDataSourceImpl();
    }

    @Test
    public void testGetContactList() {
        try {
            List<Contact> contactList = contactsDummyDataSource.getContactsList();
            Assert.assertNotNull(contactList);
            Assert.assertTrue(contactList.size() > 0);
        } catch (RepositoryErrorException e) {
            Assert.fail();
        }
    }

    @Test
    public void testGetContact() {
        try {
            final String CONTACT_ID = "-K4UQQaYwd7RHVdZoOCI";
            final String EMAIL = "roberto.martin@example.com";

            Contact contact = contactsDummyDataSource.getContact(CONTACT_ID);
            Assert.assertEquals(contact.getEmail(), EMAIL);
        } catch (RepositoryErrorException e) {
            Assert.fail();
        }
    }

    @Test
    public void testGetContactNotExist() {
        try {
            final String CONTACT_ID = "fake-test";

            Contact contact = contactsDummyDataSource.getContact(CONTACT_ID);
            Assert.assertNull(contact);
        } catch (RepositoryErrorException e) {
            Assert.fail();
        }
    }

    @Test
    public void testAddContact() {
        try {
            Contact contact = createTestContact(null);
            contactsDummyDataSource.addContact(contact);

            Contact testAddContact = contactsDummyDataSource.getContact(contact.getId());
            Assert.assertEquals(contact.getEmail(), testAddContact.getEmail());
        } catch (RepositoryErrorException e) {
            Assert.fail();
        }
    }

    @Test
    public void testEditContact() {
        try {
            final String EMAIL = "roberto.martin@example.com";

            Contact contact = createTestContact(null);
            contact = contactsDummyDataSource.addContact(contact);

            Assert.assertNotEquals(EMAIL, contact.getEmail());

            contact.setEmail(EMAIL);
            contactsDummyDataSource.editContact(contact);

            Contact testEditContact = contactsDummyDataSource.getContact(contact.getId());
            Assert.assertEquals(EMAIL, testEditContact.getEmail());

        } catch (RepositoryErrorException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDeleteContact() {
        try {
            Contact contact = createTestContact(null);
            contact = contactsDummyDataSource.addContact(contact);
            Contact testAddContact = contactsDummyDataSource.getContact(contact.getId());
            Assert.assertNotNull(testAddContact);

            contactsDummyDataSource.deleteContact(contact.getId());
            testAddContact = contactsDummyDataSource.getContact(contact.getId());
            Assert.assertNull(testAddContact);

        } catch (RepositoryErrorException e) {
            Assert.fail();
        }
    }

    private Contact createTestContact(String id) {
        Picture picture = new Picture();
        picture.setPicture("prueba");
        picture.setThumbnail("prueba");

        Location location = new Location();
        location.setCity("Ourense");
        location.setZip("32002");
        location.setState("Ourense");
        location.setStreet("Rúa do olvido");

        Contact contact = new Contact();
        contact.setId(id);
        contact.setFirstName("Prueba");
        contact.setLastName("test");
        contact.setGender("Male");
        contact.setLocation(location);
        contact.setEmail("prueba@test.com");
        contact.setUsername("prueba");
        contact.setPassword("prueba");
        contact.setSalt("prueba");
        contact.setMd5("prueba");
        contact.setSha1("prueba");
        contact.setSha256("prueba");
        contact.setRegistered(new Date());
        contact.setDob(new Date());
        contact.setPhone("prueba");
        contact.setCell("prueba");
        contact.setDNI("prueba");
        contact.setPicture(picture);
        return contact;
    }

}
