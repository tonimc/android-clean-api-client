package xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.mapper;

import java.util.LinkedList;
import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Picture;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.ContactDTO;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class MapperContactDTO {

    private static final MapperLocationDTO MAPPER_LOCATION = new MapperLocationDTO();

    public MapperContactDTO() {
    }

    public Contact mapper(ContactDTO contactDTO) {
        Picture picture = new Picture();
        picture.setPicture(contactDTO.getImage());
        picture.setThumbnail(contactDTO.getThumbail());

        Contact contact = new Contact();
        contact.setId(contactDTO.getId());
        contact.setGender(contactDTO.getGender());
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setLocation(MAPPER_LOCATION.mapper(contactDTO.getLocation()));
        contact.setEmail(contactDTO.getEmail());
        contact.setUsername(contactDTO.getUsername());
        contact.setPassword(contactDTO.getPassword());
        contact.setRegistered(contactDTO.getRegistered());
        contact.setDob(contactDTO.getDob());
        contact.setPhone(contactDTO.getPhone());
        contact.setCell(contactDTO.getCell());
        contact.setDNI(contactDTO.getDNI());
        contact.setPicture(picture);
        return contact;
    }

    public ContactDTO mapper(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setGender(contact.getGender());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setLocation(MAPPER_LOCATION.mapper(contact.getLocation()));
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setUsername(contact.getUsername());
        contactDTO.setPassword(contact.getPassword());
        contactDTO.setRegistered(contact.getRegistered());
        contactDTO.setDob(contact.getDob());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setCell(contact.getCell());
        contactDTO.setDNI(contact.getDNI());
        contactDTO.setImage(contact.getPicture().getPicture());
        contactDTO.setThumbail(contact.getPicture().getThumbnail());
        return contactDTO;
    }

    public List<ContactDTO> mapperList(List<Contact> contactList) {
        List<ContactDTO> contactDTOs = new LinkedList<>();
        for ( Contact contact : contactList ) {
            contactDTOs.add(mapper(contact));
        }
        return contactDTOs;
    }

}
