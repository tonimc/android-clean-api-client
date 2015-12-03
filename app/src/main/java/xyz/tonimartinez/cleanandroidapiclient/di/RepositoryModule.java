package xyz.tonimartinez.cleanandroidapiclient.di;

import xyz.tonimartinez.cleanandroidapiclient.domain.repository.ContactsRepository;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.ContactsRepositoryImpl;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class RepositoryModule {
    public static ContactsRepository provideContactsRepository() {
        return new ContactsRepositoryImpl(DataModule.provideContatsApiDataSource());
    }
}
