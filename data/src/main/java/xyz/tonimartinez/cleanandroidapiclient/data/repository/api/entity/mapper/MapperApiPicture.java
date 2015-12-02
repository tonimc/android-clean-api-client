package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.mapper;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiPicture;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Picture;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class MapperApiPicture {

    public MapperApiPicture() {
    }

    ApiPicture mapper(Picture picture) {
        ApiPicture apiPicture = new ApiPicture();
        apiPicture.setLarge(picture.getPicture());
        apiPicture.setMedium(picture.getPicture());
        apiPicture.setThumbnail(picture.getThumbnail());
        return apiPicture;
    }

    Picture mapper(ApiPicture apiPicture) {
        Picture picture = new Picture();
        picture.setThumbnail(apiPicture.getMedium());
        picture.setPicture(apiPicture.getLarge());
        return picture;
    }

}
