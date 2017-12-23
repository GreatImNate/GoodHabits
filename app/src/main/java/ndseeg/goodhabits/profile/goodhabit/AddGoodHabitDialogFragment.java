package ndseeg.goodhabits.profile.goodhabit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.Item;

/**
 * Created by ndseeg on 12/2/17.
 */

public class AddGoodHabitDialogFragment extends DialogFragment {

    private final static String TAG = "AddGoodHabitDialog";

    private OnCompleteListener onCompleteListener;

    private EditText goodHabitName;
    private EditText goodHabitDescription;

    private CheckBox[] checkBoxes;

    private GoodHabitItem item;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Fill in values if something was missing when user tried saving, can also be used for editing
        item = getArguments().getParcelable("Item");
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.add_good_habit, null);
        goodHabitName = (EditText) view.findViewById(R.id.good_habit_name_edit);
        goodHabitDescription = (EditText) view.findViewById(R.id.good_habit_description_edit);
        checkBoxes = new CheckBox[] {(CheckBox) view.findViewById(R.id.check_sunday_gh),
                (CheckBox) view.findViewById(R.id.check_monday_gh),
                (CheckBox) view.findViewById(R.id.check_tuesday_gh),
                (CheckBox) view.findViewById(R.id.check_wednesday_gh),
                (CheckBox) view.findViewById(R.id.check_thursday_gh),
                (CheckBox) view.findViewById(R.id.check_friday_gh),
                (CheckBox) view.findViewById(R.id.check_saturday_gh)};

        if (item != null){
            Log.d(TAG, "onCreateDialog is being called with an item, setting fields");
            goodHabitDescription.setText(item.getDescription());
            for (int i = 0; i < checkBoxes.length; i++) {
                checkBoxes[i].setChecked(item.getDaysOfTheWeek()[i]);
            }

        }

        builder.setView(view);
        builder.setMessage(R.string.good_habit)
                .setPositiveButton(R.string.alert_dialog_save,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                boolean result = positiveClick(dialog);
                                if (result)
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

    public boolean positiveClick(DialogInterface dialogInterface) {
        Dialog dialog = (Dialog) dialogInterface;
        goodHabitName = (EditText) dialog.findViewById(R.id.good_habit_name_edit);
        goodHabitDescription = (EditText) dialog.findViewById(R.id.good_habit_description_edit);
        item = new GoodHabitItem();
        item.setName(goodHabitName.getText().toString());
        item.setDescription(goodHabitDescription.getText().toString());

        CheckBox[] checkBoxes = {(CheckBox) dialog.findViewById(R.id.check_sunday_gh),
                (CheckBox) dialog.findViewById(R.id.check_monday_gh),
                (CheckBox) dialog.findViewById(R.id.check_tuesday_gh),
                (CheckBox) dialog.findViewById(R.id.check_wednesday_gh),
                (CheckBox) dialog.findViewById(R.id.check_thursday_gh),
                (CheckBox) dialog.findViewById(R.id.check_friday_gh),
                (CheckBox) dialog.findViewById(R.id.check_saturday_gh)};
        item.setDaysOfTheWeek(checkBoxes);
        StringBuilder sb = new StringBuilder();
        for (CheckBox check: checkBoxes) {
            sb.append(check.isChecked());
            sb.append(" ");

        }
        Log.d(TAG, "Value of checkBoxes: " + sb.toString());
        if (goodHabitName.getText().toString().equals("")) {
            // If the
            Log.d(TAG, "EDIT TEXT IS NULL");
            DialogFragment addGoodHabitDialogFragment = newInstance(item);
            addGoodHabitDialogFragment.show(getFragmentManager(), "addGoodHabit");
            return false;
        }
        Log.d(TAG, "positiveClick: " + goodHabitName.getText());
        // Pass the values from dialog fragment back to the activity
        this.onCompleteListener.onComplete(item);
        return true;

    }

    public static AddGoodHabitDialogFragment newInstance(@Nullable Item item) {
        
        Bundle args = new Bundle();
        
        AddGoodHabitDialogFragment fragment = new AddGoodHabitDialogFragment();
        args.putParcelable("Item", item);
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
