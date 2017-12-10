package ndseeg.goodhabits.profile.goodhabit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.Item;

/**
 * Created by ndseeg on 12/2/17.
 */

public class AddGoodHabitDialogFragment extends DialogFragment {

    private final static String TAG = "AddGoodHabitDialog";

    private OnCompleteListener onCompleteListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(R.layout.add_good_habit);
        builder.setMessage(R.string.test)
                .setPositiveButton(R.string.alert_dialog_save,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Dialog test = (Dialog) dialog;
                                EditText goodHabitName = (EditText) test.findViewById(R.id.good_habit_name_edit);
                                Log.d(TAG, "Is the name getting set in the dialog fragment? " + goodHabitName.getText());
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
        EditText editText = (EditText) getActivity().findViewById(R.id.good_habit_name_edit);
        if (editText == null) {
            Log.d(TAG, "EDIT TEXT IS NULL");
            return;
        }
        Log.d(TAG, "positiveClick: " + editText.getText());
    }

    public static AddGoodHabitDialogFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddGoodHabitDialogFragment fragment = new AddGoodHabitDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public static interface OnCompleteListener {
        public abstract void onComplete(Item item);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.onCompleteListener = (OnCompleteListener)context;
        } catch (final ClassCastException e) {
            throw new ClassCastException(context.toString() + " " + e);
        }


    }
}
