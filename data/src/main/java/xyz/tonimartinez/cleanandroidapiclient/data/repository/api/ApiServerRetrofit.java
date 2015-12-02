package xyz.tonimartinez.cleanandroidapiclient.data.repository.api;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.squareup.okhttp.OkHttpClient;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.adapter.DateTimeTypeAdapter;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ApiServerRetrofit {

    private static String API_URL = "https://users-gdgourense.firebaseio.com";
    private static Boolean LOG_ENABLE = true;

    private static ApiService apiService;

    public static ApiService getApi() {
        if ( apiService == null) {
            synchronized (ApiServerRetrofit.class) {
                if ( apiService == null) {
                    new ApiServerRetrofit();
                }
            }
        }
        return apiService;
    }

    protected ApiServerRetrofit() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(LOG_ENABLE?RestAdapter.LogLevel.FULL:RestAdapter.LogLevel.NONE)
                .setEndpoint(API_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(getConverter())
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    private Converter getConverter() {
        return new GsonConverter(new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeTypeAdapter())
                .create());
    }
}
