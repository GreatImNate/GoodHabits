package ndseeg.goodhabits.profile.goodhabit;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.AddActivity;
import ndseeg.goodhabits.profile.ConfirmOverwriteDialogFragment;
import ndseeg.goodhabits.profile.Item;
import ndseeg.goodhabits.profile.ItemAdapter;

public class GoodHabitActivity extends AddActivity implements AddGoodHabitDialogFragment.OnCompleteListener {

    private final String TAG = "GoodHabitActivity";

    private final String goodHabitFilename = "goodhabit";

    private final Gson gson = new Gson();

    private FragmentManager fragmentManager;

    private ListView listView;

    // Key will be the item name, and the value will be the actual item. This way can pull up full activity from just the name
    private Map<String, GoodHabitItem> savedGoodHabits;

    private ArrayList<Item> goodHabitItems;

    //todo add ability to delete items, change items to GoodHabitItems
    // Clicking on items should open up a dialog where

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goodHabitItems = new ArrayList<>();
        savedGoodHabits = new HashMap<>();
        fragmentManager = getFragmentManager();
        setContentView(R.layout.good_habit_activity);
        listView = (ListView) findViewById(R.id.good_habit_list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragment addGoodHabit = AddGoodHabitDialogFragment.newInstance((Item) listView.getItemAtPosition(position));
                addGoodHabit.setTargetFragment(addGoodHabit, 1);
                addGoodHabit.show(fragmentManager, "addGoodHabit");
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });
        String[] items = getItemsFromFile(goodHabitFilename);
        for (String item : items) {
            Log.d(TAG, "onCreate: Current JSON item: " + item);
            GoodHabitItem goodHabitItem = gson.fromJson(item, GoodHabitItem.class);
            goodHabitItems.add(goodHabitItem);
            savedGoodHabits.put(goodHabitItem.getName(), goodHabitItem);
        }
        ItemAdapter itemAdapter = new ItemAdapter(this, goodHabitItems);
        listView = (ListView) findViewById(R.id.good_habit_list_view);
        listView.setAdapter(itemAdapter);
    }

    public void addGoodHabit(View view) {
        DialogFragment addGoodHabit = AddGoodHabitDialogFragment.newInstance(null);
        addGoodHabit.setTargetFragment(addGoodHabit, 1);
        addGoodHabit.show(fragmentManager, "addGoodHabit");

    }

    // Todo change write out to only be on activity kill/close otherwise keep everything local in memory. Still need to fix error of parsing wrong
    private void writeOutItem(final Item item) {
        GoodHabitItem goodHabitItem = (GoodHabitItem) item;
        try (OutputStreamWriter writer = new OutputStreamWriter(openFileOutput(goodHabitFilename, Context.MODE_APPEND))) {
            String json = gson.toJson(goodHabitItem);
            writer.append(json);
            writer.append("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onComplete(final Item item) {
        Log.i(TAG, "onComplete: User entered in item to be saved");
        // todo check for duplicates before writing out/saving to array list
        if (savedGoodHabits.containsKey(item.getName())) {
            // User is overwriting saved good habit
            if (! savedGoodHabits.get(item.getName()).equals(item)) {
                Log.d(TAG, "onComplete: Changes have been made to item name=" + item.getName() +
                        " savedItem: " + savedGoodHabits.get(item.getName()) +
                        " alteredItem: " + item);
                DialogFragment confirmDialog = ConfirmOverwriteDialogFragment.newInstance("Do you want to update Good Habit?");
                confirmDialog.setTargetFragment(confirmDialog, 5);
                confirmDialog.show(fragmentManager, "confirmUpdate");
                // todo: If changes have been made to the item overwrite value in map and in final then refresh, otherwise
            }
        } else {
            // todo add to map
            // Else if new Item, add to the map and refresh the activity
            writeOutItem(item);
            finish();
            startActivity(getIntent());

        }
    }

}
