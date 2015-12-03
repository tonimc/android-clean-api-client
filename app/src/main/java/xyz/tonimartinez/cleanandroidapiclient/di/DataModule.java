package xyz.tonimartinez.cleanandroidapiclient.di;

import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDummyDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource.ContactsApiDataSource;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class DataModule {

    private static String API_DUMMY = "dummy";
    private static String API_REST = "rest";

    public static ContactsApiDataSource provideContatsApiDataSource() {
        //return new ContactsApiDummyDataSourceImpl();
        return new ContactsApiDataSourceImpl();
    }
}
