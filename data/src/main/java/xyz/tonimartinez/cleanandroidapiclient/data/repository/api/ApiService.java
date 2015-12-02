package xyz.tonimartinez.cleanandroidapiclient.data.repository.api;


import java.util.HashMap;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiContact;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.response.ResponseAddUser;

/**
 * Created by Toni Martinez on 1/12/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ApiService {

    @GET("/users.json")
    HashMap<String, ApiContact> listUsers();

    @GET("/users/{id}/.json")
    ApiContact getUser(@Path("id") String id);

    @POST("/users.json")
    ResponseAddUser addUser(@Body ApiContact user);

    @PUT("/users/{id}/.json")
    ApiContact editUser(@Path("id") String id, @Body ApiContact user);

    @DELETE("/users/{id}/.json")
    Object delUser(@Path("id") String id);

}