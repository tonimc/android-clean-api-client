package xyz.tonimartinez.cleanandroidapiclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import xyz.tonimartinez.cleanandroidapiclient.R;
import xyz.tonimartinez.cleanandroidapiclient.ui.adapter.ContactsAdapter;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.ContactListPresenter;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.ContactDTO;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view.ContactListView;

public class ContactListActivity extends BaseActivity implements ContactListView {

    @Bind(R.id.toolbar) protected Toolbar mToolbar;
    @Bind(R.id.contact_list_RV) protected RecyclerView mProductsListRV;
    @Bind(R.id.add_contact) FloatingActionButton mAddContactBT;

    private ContactsAdapter mContactsAdapter;

    private ContactListPresenter contactListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactListPresenter = new ContactListPresenter(this);
        setupLayout();
        contactListPresenter.getContactList();
    }

    private void setupLayout() {
        mAddContactBT.setVisibility(View.GONE);

        mContactsAdapter = new ContactsAdapter(new ArrayList<ContactDTO>());
        mContactsAdapter.setOnItemClickListener(new ContactsAdapter.OnItemClickListener() {
            @Override
            public void onClick(ContactDTO item) {
                Intent intent = ContactDetailActivity.navigate(ContactListActivity.this, item.getId());
                startActivity(intent);
            }
        });

        mProductsListRV.setLayoutManager(new GridLayoutManager(this, 2));
        mProductsListRV.setHasFixedSize(true);
        mProductsListRV.setAdapter(mContactsAdapter);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_contact_list;
    }


    @Override
    public void renderContactList(List<ContactDTO> contactDTOList) {
        mContactsAdapter.clear();
        mContactsAdapter.addAll(contactDTOList);
    }

    @Override
    public void openContact() {

    }
}
