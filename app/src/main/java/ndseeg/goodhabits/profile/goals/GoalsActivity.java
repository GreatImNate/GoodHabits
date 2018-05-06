package ndseeg.goodhabits.profile.goals;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.view.View;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.AddActivity;

/**
 * Created by ndseeg on 12/8/17.
 */

public class GoalsActivity extends AddActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
        setContentView(R.layout.goals_activity);

    }

    public void addGoals(View view) {
        DialogFragment addGoalsFragment = AddGoalsDialogFragment.newInstance(null);
//        addGoalsFragment.setTargetFragment(addGoalsFragment, 2);
        addGoalsFragment.show(fragmentManager, "addGoals");
    }
}
