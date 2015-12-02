package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Location;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Picture;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource.ContactsApiDataSource;
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.DatasourceErrorException;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactsApiDummyDataSourceImpl implements ContactsApiDataSource {

    private List<Contact> contactList = new LinkedList<>();

    public ContactsApiDummyDataSourceImpl() {
        Picture picture = new Picture();
        picture.setThumbnail("http://siliconvalleyrealtyworld.com/files/2011/09/Crash_Test_Dummy.jpg");
        picture.setPicture("http://siliconvalleyrealtyworld.com/files/2011/09/Crash_Test_Dummy.jpg");

        Contact contact1 = new Contact();
        contact1.setId("1");
        contact1.setEmail("contacto1@dummy.es");
        contact1.setFirstName("Dummy 1");
        contact1.setLastName("Test");
        contact1.setCell("999-888-777");
        contact1.setDNI("99999999R");
        contact1.setDob(new Date());
        contact1.setGender("Male");
        contact1.setLocation(new Location());
        contact1.setPicture(picture);

        Picture picture2 = new Picture();
        picture.setThumbnail("http://www.autofacil.es/elementosWeb/gestionCajas/AUF/Image/Dummy.jpg");
        picture.setPicture("http://www.autofacil.es/elementosWeb/gestionCajas/AUF/Image/Dummy.jpg");

        Contact contact2 = new Contact();
        contact1.setId("2");
        contact1.setEmail("contacto2@dummy.es");
        contact1.setFirstName("Dummy 2");
        contact1.setLastName("Test");
        contact1.setCell("999-888-777");
        contact1.setDNI("99999999R");
        contact1.setDob(new Date());
        contact1.setGender("Male");
        contact1.setLocation(new Location());
        contact1.setPicture(picture2);

        contactList.add(contact1);
        contactList.add(contact2);
    }

    @Override
    public Contact getContact(String id) {
        for ( Contact contact : contactList ) {
            if ( id.equals(contact.getId()) ) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> getContactsList() {
        return contactList;
    }

    @Override
    public Contact addContact(Contact contact) {
        contactList.add(contact);
        return contact;
    }

    @Override
    public Contact editContact(Contact contact) {
        for ( int i = 0; i < contactList.size(); i++ ) {
            if ( contact.getId().equals(contactList.get(i).getId()) ) {
                contactList.remove(i);
                contactList.add(i, contact);
            }
        }
        return contact;
    }

    @Override
    public boolean deleteContact(String id) throws DatasourceErrorException {
        for ( int i = 0; i < contactList.size(); i++ ) {
            if ( id.equals(contactList.get(i).getId()) ) {
                contactList.remove(i);
                return true;
            }
        }
        return false;
    }
}
