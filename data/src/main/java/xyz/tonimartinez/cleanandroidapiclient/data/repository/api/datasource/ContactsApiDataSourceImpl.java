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
import xyz.tonimartinez.cleanandroidapiclient.repository.exception.DatasourceErrorException;

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
    public Contact getContact(String id) throws DatasourceErrorException {
        try {

            ApiContact response = dataService.getUser(id);
            return ( response != null )?
                    mapperApiContact.mapper(response, id):
                    null;

        } catch (RetrofitError e) {
            throw processException(e);
        } catch (Throwable e) {
            throw new DatasourceErrorException(new ApiErrorException(e));
        }
    }


    @Override
    public List<Contact> getContactsList() throws DatasourceErrorException {
        try {

            HashMap<String,ApiContact> response = dataService.listUsers();
            return mapperApiContact.mapperList(response);

        } catch (RetrofitError e) {
            throw processException(e);
        } catch (Throwable e) {
            throw new DatasourceErrorException(new ApiErrorException(e));
        }
    }

    @Override
    public Contact addContact(Contact contact) throws DatasourceErrorException {
        try {

            ApiContact apiContact = mapperApiContact.mapper(contact);
            ResponseAddUser response = dataService.addUser(apiContact);
            contact.setId(response.getName());
            return contact;

        } catch (RetrofitError e) {
            throw processException(e);
        } catch (Throwable e) {
            throw new DatasourceErrorException(new ApiErrorException(e));
        }
    }

    @Override
    public Contact editContact(Contact contact) throws DatasourceErrorException {
        try {

            ApiContact apiContact = mapperApiContact.mapper(contact);
            ApiContact response = dataService.editUser(contact.getId(), apiContact);
            return mapperApiContact.mapper(response, contact.getId());

        } catch (RetrofitError e) {
            throw processException(e);
        } catch (Throwable e) {
            throw new DatasourceErrorException(new ApiErrorException(e));
        }
    }

    @Override
    public boolean deleteContact(String id) throws DatasourceErrorException {
        try {

            dataService.delUser(id);
            return true;

        } catch (RetrofitError e) {
            throw processException(e);
        } catch (Throwable e) {
            throw new DatasourceErrorException(new ApiErrorException(e));
        }
    }

    private DatasourceErrorException processException(RetrofitError e) throws DatasourceErrorException {
        if (RetrofitError.Kind.HTTP.equals(e.getKind())
                || RetrofitError.Kind.NETWORK.equals(e.getKind())) {
            throw new DatasourceErrorException(new ApiNetworkException(e));
        }
        if (RetrofitError.Kind.CONVERSION.equals(e.getKind())) {
            throw new DatasourceErrorException(new ApiConversionException(e));
        }
        throw new DatasourceErrorException(new ApiErrorException(e));
    }
}
