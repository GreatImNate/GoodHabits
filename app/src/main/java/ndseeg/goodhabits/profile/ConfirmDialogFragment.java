package ndseeg.goodhabits.profile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import lombok.Setter;
import ndseeg.goodhabits.R;

/**
 * Created by ndseeg on 12/26/17.
 */

public abstract class ConfirmDialogFragment extends DialogFragment {

    @Setter
    private String titleMessage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (getArguments().getString("titleMessage") != null) {
            titleMessage = getArguments().getString("titleMessage");
        } else {
            titleMessage = "Confirm";
        }
        builder.setTitle(titleMessage);
        builder.setMessage(R.string.good_habit)
                .setPositiveButton(R.string.alert_dialog_save,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dismiss();
                            }
                        })
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dismiss();
                            }
                        });

        return builder.create();
    }
}
