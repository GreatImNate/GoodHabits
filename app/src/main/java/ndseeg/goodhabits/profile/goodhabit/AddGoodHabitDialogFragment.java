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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.Item;
import ndseeg.goodhabits.utils.AppDatabase;

public class AddGoodHabitDialogFragment extends DialogFragment {

    private final static String TAG = "AddGoodHabitDialog";

    private OnCompleteListener onCompleteListener;

    private EditText goodHabitName;
    private EditText goodHabitDescription;

    private CheckBox[] checkBoxes;

    private GoodHabitItem item;

    private AppDatabase appDatabase;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        appDatabase = AppDatabase.getInstance(getActivity().getApplicationContext());


        // Fill in values if something was missing when user tried saving, can also be used for editing
        item = getArguments().getParcelable("AbstractItem");
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.add_good_habit_dialog_fragment, null);
        goodHabitName = (EditText) view.findViewById(R.id.good_habit_name_edit);
        goodHabitDescription = (EditText) view.findViewById(R.id.good_habit_description_edit);


        // todo have a dropdown to chose whether a option needs to be done on specific days of the week, arbitrary days of the week, or a single event
        checkBoxes = new CheckBox[] {(CheckBox) view.findViewById(R.id.check_sunday_gh),
                (CheckBox) view.findViewById(R.id.check_monday_gh),
                (CheckBox) view.findViewById(R.id.check_tuesday_gh),
                (CheckBox) view.findViewById(R.id.check_wednesday_gh),
                (CheckBox) view.findViewById(R.id.check_thursday_gh),
                (CheckBox) view.findViewById(R.id.check_friday_gh),
                (CheckBox) view.findViewById(R.id.check_saturday_gh)};

        if (item != null){
            Log.d(TAG, "onCreateDialog is being called with an item, setting fields");
            if (!(item.getName().isEmpty() || item.getName() == null)) {
                goodHabitName.setText(item.getName());
                goodHabitName.setFocusable(false);
                goodHabitName.setEnabled(false);
            }
            goodHabitDescription.setText(item.getDescription());
            for (int i = 0; i < checkBoxes.length; i++) {
                checkBoxes[i].setChecked(item.getDaysOfTheWeek()[i]);
            }
            // todo add value field

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
                        }).setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                appDatabase.dao().deleteGoodHabitItem(item);
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

    public boolean positiveClick(DialogInterface dialogInterface) {
        Dialog dialog = (Dialog) dialogInterface;
        goodHabitName = (EditText) dialog.findViewById(R.id.good_habit_name_edit);
        goodHabitDescription = (EditText) dialog.findViewById(R.id.good_habit_description_edit);
        item = new GoodHabitItem();
        item.setName(goodHabitName.getText().toString());
        item.setDescription(goodHabitDescription.getText().toString());
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
        args.putParcelable("AbstractItem", item);
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
