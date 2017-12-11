package ndseeg.goodhabits.profile.goodhabit;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.Item;

public class GoodHabitActivity extends Activity implements AddGoodHabitDialogFragment.OnCompleteListener {

    private final String TAG = "GoodHabitActivity";

    private FragmentManager fragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
        Log.d(TAG, "onCreate: Is this getting created?");
        setContentView(R.layout.good_habit_activity);
    }

    public void addGoodHabit(View view) {
        DialogFragment addGoodHabit = AddGoodHabitDialogFragment.newInstance(null);
        addGoodHabit.setTargetFragment(addGoodHabit, 1);
        addGoodHabit.show(fragmentManager, "addGoodHabit");

    }

    @Override
    public void onComplete(Item item) {
        Log.d(TAG, "Item returned from dialogFragment: " + item.toString());
    }
}
