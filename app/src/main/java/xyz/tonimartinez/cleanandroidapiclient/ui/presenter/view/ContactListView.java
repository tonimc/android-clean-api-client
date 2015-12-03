package xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view;

import java.util.List;

import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.ContactDTO;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public interface ContactListView {

    void renderContactList(List<ContactDTO> contactDTOList);
    void openContact();
    void showError(String error);
    void showError(int resString);
    void showMessage(String error);
    void showMessage(int resString);
    void showLoading();
    void hideLoading();

}
