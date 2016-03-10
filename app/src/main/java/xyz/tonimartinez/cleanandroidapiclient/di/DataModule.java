package xyz.tonimartinez.cleanandroidapiclient.di;

import xyz.tonimartinez.cleanandroidapiclient.BuildConfig;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource.ContactsApiDummyDataSourceImpl;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource.ContactsApiDataSource;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class DataModule {

    private final static String DUMMY_SOURCE = "DUMMY";

    public static ContactsApiDataSource provideContatsApiDataSource() {
        return (DUMMY_SOURCE.equals(BuildConfig.API_TYPE))?
                new ContactsApiDummyDataSourceImpl():
                new ContactsApiDataSourceImpl();
    }
}
