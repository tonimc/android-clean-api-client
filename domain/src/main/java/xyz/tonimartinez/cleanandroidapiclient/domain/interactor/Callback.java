package xyz.tonimartinez.cleanandroidapiclient.domain.interactor;

/**
 * Created by Toni Martinez on 29/11/15.
 * toni.martinez.carballo@gmail.com
 */
public interface Callback<T> {
    public void onSuccess(T object);
    public void onFailure(Error error);
}