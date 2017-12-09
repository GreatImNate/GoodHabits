package ndseeg.goodhabits;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by ndseeg on 12/2/17.
 */

public class AddGoodHabitDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(R.layout.add_good_habit);
        builder.setMessage(R.string.test)
                .setPositiveButton(R.string.alert_dialog_save,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                positiveClick();
                                dismiss();
                            }
                        })
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dismiss();
                            }
                        });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    public void positiveClick() {
        EditText editText = (EditText) getActivity().findViewById(R.id.edit_test);
        if (editText == null) {
            Log.d("Dialog", "EDIT TEXT IS NULL");
        }
        ((MainActivity) getActivity()).goodHabitPostiveClick();
    }

}
