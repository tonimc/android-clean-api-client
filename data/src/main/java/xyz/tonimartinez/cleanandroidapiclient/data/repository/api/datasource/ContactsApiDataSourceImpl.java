package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.datasource;

import java.util.HashMap;
import java.util.List;

import retrofit.RetrofitError;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.ApiServerRetrofit;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.ApiService;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.ApiContact;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.entity.mapper.MapperApiContact;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.exception.ApiConversionException;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.exception.ApiErrorException;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.exception.ApiNetworkException;
import xyz.tonimartinez.cleanandroidapiclient.data.repository.api.response.ResponseAddUser;
import xyz.tonimartinez.cleanandroidapiclient.domain.model.Contact;
import xyz.tonimartinez.cleanandroidapiclient.repository.contacts.datasource.ContactsApiDataSource;
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.RepositoryErrorException;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class ContactsApiDataSourceImpl implements ContactsApiDataSource {

    private ApiService dataService;
    private MapperApiContact mapperApiContact;

    public ContactsApiDataSourceImpl() {
        this.dataService = ApiServerRetrofit.getApi();
        this.mapperApiContact = new MapperApiContact();
    }

    @Override
    public Contact getContact(String id) throws RepositoryErrorException {
        try {

            ApiContact response = dataService.getUser(id);
            return mapperApiContact.mapper(response);

        } catch (RetrofitError e) {
            if (RetrofitError.Kind.HTTP.equals(e.getKind())
                    || RetrofitError.Kind.NETWORK.equals(e.getKind())) {
                throw new RepositoryErrorException(new ApiNetworkException(e));
            }
            if (RetrofitError.Kind.CONVERSION.equals(e.getKind())) {
                throw new RepositoryErrorException(new ApiConversionException(e));
            }
            throw new RepositoryErrorException(new ApiErrorException(e));

        } catch (Throwable e) {
            throw new RepositoryErrorException(new ApiErrorException(e));
        }

    }

    @Override
    public List<Contact> getContactsList() throws RepositoryErrorException {
        try {

            HashMap<String,ApiContact> response = dataService.listUsers();
            return mapperApiContact.mapperList(response.values());

        } catch (RetrofitError e) {
            if (RetrofitError.Kind.HTTP.equals(e.getKind())
                    || RetrofitError.Kind.NETWORK.equals(e.getKind())) {
                throw new RepositoryErrorException(new ApiNetworkException(e));
            }
            if (RetrofitError.Kind.CONVERSION.equals(e.getKind())) {
                throw new RepositoryErrorException(new ApiConversionException(e));
            }
            throw new RepositoryErrorException(new ApiErrorException(e));

        } catch (Throwable e) {
            throw new RepositoryErrorException(new ApiErrorException(e));
        }
    }

    @Override
    public Contact addContact(Contact contact) throws RepositoryErrorException {
        try {
            ApiContact apiContact = mapperApiContact.mapper(contact);
            ResponseAddUser response = dataService.addUser(apiContact);
            contact.setId(response.getName());
            return contact;

        } catch (RetrofitError e) {
            if (RetrofitError.Kind.HTTP.equals(e.getKind())
                    || RetrofitError.Kind.NETWORK.equals(e.getKind())) {
                throw new RepositoryErrorException(new ApiNetworkException(e));
            }
            if (RetrofitError.Kind.CONVERSION.equals(e.getKind())) {
                throw new RepositoryErrorException(new ApiConversionException(e));
            }
            throw new RepositoryErrorException(new ApiErrorException(e));

        } catch (Throwable e) {
            throw new RepositoryErrorException(new ApiErrorException(e));
        }
    }

    @Override
    public Contact editContact(Contact contact) throws RepositoryErrorException {
        return null;
    }

    @Override
    public boolean deleteContact(Contact contact) throws RepositoryErrorException {
        return false;
    }
}
