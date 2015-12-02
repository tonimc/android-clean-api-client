package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.response;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ResponseAddUser implements ResponseApi {

    private String name;

    public ResponseAddUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
