package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.mapper;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiContact;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiContactName;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiLocation;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Location;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class MapperApiContactName {

    public MapperApiContactName() {
    }

    ApiContactName mapper(Contact contact) {
        ApiContactName apiContactName = new ApiContactName();
        apiContactName.setTitle(ApiContactName.MALE.equals(contact.getGender())?
                ApiContactName.TITLE_MALE:
                ApiContactName.TITLE_FEMALE);
        apiContactName.setFirst(contact.getFirstName());
        apiContactName.setLast(contact.getLastName());
        return apiContactName;
    }


}
