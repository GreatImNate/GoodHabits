package ndseeg.goodhabits.profile.goals;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.Item;

/**
 * Created by ndseeg on 12/24/17.
 */

public class AddGoalsDialogFragment extends DialogFragment {

    private static final String TAG = "AddGoalsDialogFragment";

    private GoalsItem item;

    private Spinner occurrences;

    private View mainView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

//        item = getArguments().getParcelable();

        final LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.add_goals_dialog_fragment, null);
        RelativeLayout mainLayout = (RelativeLayout) view.findViewById(R.id.add_goals_dialog_fragment);

        View view2 = layoutInflater.inflate(R.layout.add_generic, mainLayout, true);
        occurrences = (Spinner) view.findViewById(R.id.goals_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.goals_occurrences, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occurrences.setAdapter(adapter);
        occurrences.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemSelected: " + parent.getItemAtPosition(position));
                if (parent.getItemAtPosition(position).equals("Monthly")) {
                    Log.d(TAG, "Set to monthly");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        builder.setView(view);
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

        builder.setView(view);
        return builder.create();
    }



    public static AddGoalsDialogFragment newInstance(@Nullable Item item) {

        Bundle args = new Bundle();

        AddGoalsDialogFragment fragment = new AddGoalsDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
