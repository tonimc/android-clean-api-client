package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.mapper;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiLocation;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Location;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class MapperApiLocation {

    public MapperApiLocation() {
    }

    ApiLocation mapper(Location location) {
        ApiLocation apiLocation = new ApiLocation();
        apiLocation.setStreet(location.getStreet());
        apiLocation.setCity(location.getCity());
        apiLocation.setState(location.getState());
        apiLocation.setZip(location.getZip());
        return apiLocation;
    }

    Location mapper(ApiLocation apiLocation) {
        Location location = new Location();
        location.setStreet(apiLocation.getStreet());
        location.setCity(apiLocation.getCity());
        location.setState(apiLocation.getState());
        location.setZip(apiLocation.getZip());
        return location;
    }
}
