package ndseeg.goodhabits;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import ndseeg.goodhabits.profile.ProfileFragment;
import ndseeg.goodhabits.tracking.CalendarFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    private FragmentManager fragmentManager = getFragmentManager();

    private TextView mTextMessage;

    private final Calendar calendar = Calendar.getInstance();


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
                case R.id.navigation_profile:
                    fragment = ProfileFragment.newInstance();
                    Log.d(TAG, "Selecting GOALS Navigation");

                    break;
                case R.id.navigation_calendar:
                    fragment = CalendarFragment.newInstance();
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
        calendar.setTime(new Date(System.currentTimeMillis()));
        Log.d(TAG, "Current Day of the week is " + calendar.get(Calendar.DAY_OF_WEEK));
    }
    //day of week is one based indexing


    public void goodHabitPostiveClick() {
        Log.d(TAG, "Postivie Vibes");
    }

}
