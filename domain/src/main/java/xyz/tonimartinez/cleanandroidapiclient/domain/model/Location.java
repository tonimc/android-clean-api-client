package xyz.tonimartinez.cleanandroidapiclient.domain.model;

/**
 * Created by Toni Martinez on 30/11/15.
 * toni.martinez.carballo@gmail.com
 */
public class Location {

    public String street;
    public String city;
    public String state;
    public String zip;

    public Location() {
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
