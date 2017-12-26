package ndseeg.goodhabits;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ndseeg.goodhabits.utils.FileHandler;

/**
 * Created by Nathan Seegmiller on 11/19/2017.
 */

public class HomeFragment extends Fragment {

    private final Calendar calendar = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View homeView = inflater.inflate(R.layout.home_fragment, container, false);
        TextView currentDayOfTheWeek = (TextView) homeView.findViewById(R.id.message);
        TextView activeHabitsForTheDay = (TextView) homeView.findViewById(R.id.active_good_habits);
        calendar.setTime(new Date(System.currentTimeMillis()));
        String[] items = FileHandler.getItemsFromFile("goodhabit", getActivity().getBaseContext());
        currentDayOfTheWeek.setText("Current day of the week is " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
        activeHabitsForTheDay.setText("Current Active Habits for the day are " + Arrays.toString(items));


        return homeView;// inflater.inflate(R.layout.home_fragment, container, false);
    }

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //todo way to mark good habits/goals as completed
}
