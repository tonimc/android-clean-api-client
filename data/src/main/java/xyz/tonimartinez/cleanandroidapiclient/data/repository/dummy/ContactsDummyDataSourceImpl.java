package xyz.tonimartinez.cleanandroidapiclient.data.repository.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Location;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Picture;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactsDummyDataSourceImpl Impl {

    private List<Contact> contactList = new ArrayList<>(2);

    public ContactsDummyDataSourceImpl() {
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
}
