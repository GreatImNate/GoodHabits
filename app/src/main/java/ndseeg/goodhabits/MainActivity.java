package ndseeg.goodhabits;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ndseeg.goodhabits.goals.GoalsFragment;
import ndseeg.goodhabits.tracking.TrackingFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    private FragmentManager fragmentManager = getFragmentManager();

    private TextView mTextMessage;

    // Make public to share across all the different activities
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = HomeFragment.newInstance();
                    Log.d(TAG, "Selecting HOME Navigation");
                    break;
                case R.id.navigation_goals:
                    fragment = GoalsFragment.newInstance();
                    Log.d(TAG, "Selecting GOALS Navigation");

                    break;
                case R.id.navigation_tracking:
                    fragment = TrackingFragment.newInstance();
                    Log.d(TAG, "Selecting TRACKING Navigation");

                    break;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment).commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(R.id.content, HomeFragment.newInstance());
        fragmentTransaction.commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void addGoodHabit(View view) {
        DialogFragment dialogFragment = new AddGoodHabitDialogFragment();
        dialogFragment.show(fragmentManager, "dialog");
    }

    public void goodHabitPostiveClick() {
        Log.d(TAG, "Postivie Vibes");
    }

}
