package xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.mapper;

import xyz.tonimartinez.cleanandroidapiclient.domain.model.Location;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.LocationDTO;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class MapperLocationDTO {

    public MapperLocationDTO() {
    }

    LocationDTO mapper(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setStreet(location.getStreet());
        locationDTO.setCity(location.getCity());
        locationDTO.setState(location.getState());
        locationDTO.setZip(location.getZip());
        return locationDTO;
    }

    Location mapper(LocationDTO locationDTO) {
        Location location = new Location();
        location.setStreet(locationDTO.getStreet());
        location.setCity(locationDTO.getCity());
        location.setState(locationDTO.getState());
        location.setZip(locationDTO.getZip());
        return location;
    }
}
