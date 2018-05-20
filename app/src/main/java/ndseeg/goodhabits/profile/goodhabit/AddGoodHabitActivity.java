package ndseeg.goodhabits.profile.goodhabit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;


import java.util.Arrays;
import java.util.List;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.utils.AppDatabase;

public class AddGoodHabitActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = "ADD_GH_ACTIVITY";

    private final FragmentManager fragmentManager = getFragmentManager();

    private AppDatabase appDatabase;

    private RelativeLayout layout;
    private ArrayAdapter<String> recurrenceAdapter;
    private Spinner recurrenceSpinner;
    private LayoutInflater layoutInflater;

    private GoodHabitItem addItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        addItem = new GoodHabitItem();
        setContentView(R.layout.add_good_habit_activity);
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = (RelativeLayout) findViewById(R.id.good_habit_layout);
        List<String> recurrence = Arrays.asList(getResources().getStringArray(R.array.good_habit_recurrence));
        recurrenceAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, recurrence);
        recurrenceSpinner = (Spinner) findViewById(R.id.recurrence_spinner);
        recurrenceSpinner.setAdapter(recurrenceAdapter);
        recurrenceSpinner.setOnItemSelectedListener(this);
        recurrenceSpinner.setSelection(0);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemClick: Recurrence Item Selected " + recurrenceSpinner.getSelectedItem().toString());
        Fragment fragment = null;
        switch (recurrenceSpinner.getSelectedItem().toString()) {
            case "Daily": {
                fragment = DailyRecurrenceFragment.newInstance();
                break;
            }
            case "Weekly": {
                fragment = WeeklyRecurrenceFragment.newInstance();
                break;
            }
            case "Monthly": {
                break;
            }
            default: break;
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.recurrence_layout, fragment).commit();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveGoodHabit(View view) {
        EditText ghName = (EditText) findViewById(R.id.good_habit_name);
        EditText ghDescription = (EditText) findViewById(R.id.good_habit_description);
        addItem.setName(ghName.getText().toString());
        addItem.setDescription(ghDescription.getText().toString());
        appDatabase.dao().insertGoodHabit(addItem);
        finish();
    }
}
