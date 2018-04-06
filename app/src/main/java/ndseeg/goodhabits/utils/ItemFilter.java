package ndseeg.goodhabits.utils;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ndseeg.goodhabits.profile.Item;
import ndseeg.goodhabits.profile.goodhabit.GoodHabitItem;

/**
 * Created by ndseeg on 12/26/17.
 */

public class ItemFilter {

    private static final Gson gson = new Gson();

    private static final String TAG = "";

    // GoodHabitItem
    public static List<Item> filterItemsByDayOfTheWeek(final String[] items, final int dayOfTheWeek) {
        Log.i(TAG, "Calling filterItemsByDayOfTheWeek with parameters items:" + Arrays.toString(items) + " dayOfTheWeek" );
        List<Item> filteredItems = new ArrayList<>();
        for (String item: items) {
            GoodHabitItem filteredItem = gson.fromJson(item, GoodHabitItem.class);
            Log.d(TAG, "filteredItem Class: " + filteredItem.getClass());
            if (filteredItem.getDaysOfTheWeek()[dayOfTheWeek -1]) {
                filteredItems.add(filteredItem);
            }

        }
        return filteredItems;
    }
}
