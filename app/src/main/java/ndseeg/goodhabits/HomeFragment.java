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
import java.util.List;
import java.util.Locale;

import ndseeg.goodhabits.profile.Item;
import ndseeg.goodhabits.utils.FileHandler;
import ndseeg.goodhabits.utils.ItemFilter;

/**
 * Created by Nathan Seegmiller on 11/19/2017.
 */

public class HomeFragment extends Fragment {

    private final Calendar calendar = Calendar.getInstance();

    private TextView currentDayOfTheWeek;
    private TextView activeHabitsForTheDay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View homeView = inflater.inflate(R.layout.home_fragment, container, false);
        currentDayOfTheWeek = (TextView) homeView.findViewById(R.id.message);
        activeHabitsForTheDay = (TextView) homeView.findViewById(R.id.active_good_habits);
        calendar.setTime(calendar.getTime());
        String[] items = FileHandler.getItemsFromFile("goodhabit", getActivity().getBaseContext());
        currentDayOfTheWeek.setText("Current day of the week is " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
        List<Item> filteredItems = ItemFilter.filterItemsByDayOfTheWeek(items, calendar.get(Calendar.DAY_OF_WEEK));
        activeHabitsForTheDay.setText("Current Active Habits for the day are " + filteredItems);


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
