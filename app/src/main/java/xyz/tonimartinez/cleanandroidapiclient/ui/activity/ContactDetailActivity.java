package xyz.tonimartinez.cleanandroidapiclient.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import xyz.tonimartinez.cleanandroidapiclient.R;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.ContactDetailPresenter;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.dto.ContactDTO;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view.ContactDetailView;
import xyz.tonimartinez.cleanandroidapiclient.ui.presenter.view.ContactListView;

public class ContactDetailActivity extends BaseActivity implements ContactDetailView {

    private static final String CONTACT_ID = "id";

    @Bind(R.id.contact_image) protected ImageView mImageIV;
    @Bind(R.id.contact_name) protected TextView mNameTV;
    @Bind(R.id.contact_body) protected TextView mBodyTV;


    private ContactDetailPresenter contactDetailPresenter;

    public static Intent navigate(Context context, String id) {
        Intent intent = new Intent(context, ContactDetailActivity.class);
        intent.putExtra(ContactDetailActivity.CONTACT_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String id = getIntent().getStringExtra(CONTACT_ID);

        contactDetailPresenter = new ContactDetailPresenter(this);
        contactDetailPresenter.getContact(id);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_contact_detail;
    }


    @Override
    public void renderContact(ContactDTO contactDTO) {
        mNameTV.setText(contactDTO.getFirstName().toUpperCase() + " " +
                        contactDTO.getLastName().toUpperCase());

        mBodyTV.setText(
                "DNI: " + contactDTO.getDNI() + "\n" +
                "Gender: " + contactDTO.getGender() + "\n" +
                "Phone: " + contactDTO.getPhone() + "\n" +
                "Cell: " + contactDTO.getCell()
        );

        Picasso.with(mImageIV.getContext())
                .load(contactDTO.getThumbail())
                .fit()
                .centerCrop()
                .into(mImageIV);
    }
}
