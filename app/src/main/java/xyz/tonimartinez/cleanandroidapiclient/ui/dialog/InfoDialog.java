package xyz.tonimartinez.cleanandroidapiclient.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import xyz.tonimartinez.cleanandroidapiclient.R;

/**
 * Created by Toni Martinez on 23/10/15.
 * toni.martinez.carballo@gmail.com
 */
public class InfoDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = inflateView(R.layout.info_dialog_fragment);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view);

        return builder.create();
    }

    private View inflateView(int layout) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View view = inflater.inflate(layout, null);
        return view;
    }

}
