package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.mapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiContact;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class MapperApiContact {

    private static final MapperApiContactName MAPPER_NAME = new MapperApiContactName();
    private static final MapperApiLocation MAPPER_LOCATION = new MapperApiLocation();
    private static final MapperApiPicture MAPPER_PICTURE = new MapperApiPicture();

    public MapperApiContact() {
    }

    public Contact mapper(ApiContact apiContact, String id) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setGender(apiContact.getGender());
        contact.setFirstName(apiContact.getName().getFirst());
        contact.setLastName(apiContact.getName().getLast());
        contact.setLocation(MAPPER_LOCATION.mapper(apiContact.getLocation()));
        contact.setEmail(apiContact.getEmail());
        contact.setUsername(apiContact.getUsername());
        contact.setPassword(apiContact.getPassword());
        contact.setSalt(apiContact.getSalt());
        contact.setMd5(apiContact.getMd5());
        contact.setSha1(apiContact.getSha1());
        contact.setSha256(apiContact.getSha256());
        contact.setRegistered(apiContact.getRegistered());
        contact.setDob(apiContact.getDob());
        contact.setPhone(apiContact.getPhone());
        contact.setCell(apiContact.getCell());
        contact.setDNI(apiContact.getDNI());
        contact.setPicture(MAPPER_PICTURE.mapper(apiContact.getPicture()));
        return contact;
    }

    public ApiContact mapper(Contact contact) {
        ApiContact apiContact = new ApiContact();
        apiContact.setGender(apiContact.getGender());
        apiContact.setName(MAPPER_NAME.mapper(contact));
        apiContact.setLocation(MAPPER_LOCATION.mapper(contact.getLocation()));
        apiContact.setEmail(contact.getEmail());
        apiContact.setUsername(contact.getUsername());
        apiContact.setPassword(contact.getPassword());
        apiContact.setSalt(contact.getSalt());
        apiContact.setMd5(contact.getMd5());
        apiContact.setSha1(contact.getSha1());
        apiContact.setSha256(contact.getSha256());
        apiContact.setRegistered(contact.getRegistered());
        apiContact.setDob(contact.getDob());
        apiContact.setPhone(contact.getPhone());
        apiContact.setCell(contact.getCell());
        apiContact.setDNI(contact.getDNI());
        apiContact.setPicture(MAPPER_PICTURE.mapper(contact.getPicture()));
        return apiContact;
    }

    public List<Contact> mapperList(HashMap<String, ApiContact> apiContactList) {
        List<Contact> contacts = new LinkedList<>();
        for ( String id : apiContactList.keySet() ) {
            contacts.add(mapper(apiContactList.get(id), id));
        }
        return contacts;
    }

}
