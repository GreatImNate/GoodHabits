package ndseeg.goodhabits;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ndseeg on 12/2/17.
 */

public class AddGoodHabitDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // copied code from tictactoe project
        // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.add_good_habit);
        builder.setMessage(R.string.test)
                .setPositiveButton(R.string.alert_dialog_save,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ((MainActivity) getActivity()).goodHabitPostiveClick();
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


}
