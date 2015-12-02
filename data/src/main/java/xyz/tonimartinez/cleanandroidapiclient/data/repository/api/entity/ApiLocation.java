package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class ApiLocation {

    private String street;
    private String city;
    private String state;
    private String zip;

    public ApiLocation() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
