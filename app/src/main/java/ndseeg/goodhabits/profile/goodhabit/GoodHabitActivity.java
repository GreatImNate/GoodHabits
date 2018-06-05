package ndseeg.goodhabits.profile.goodhabit;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.AddActivity;
import ndseeg.goodhabits.profile.ConfirmOverwriteDialogFragment;
import ndseeg.goodhabits.profile.Item;
import ndseeg.goodhabits.profile.ItemAdapter;
import ndseeg.goodhabits.utils.AppDatabase;

// todo: Rename class to show that it displays/adds new good habits
public class GoodHabitActivity extends AddActivity implements AddGoodHabitDialogFragment.OnCompleteListener {

    private final int ADD_REQUEST_CODE = 1;

    private final String TAG = "GoodHabitActivity";

    private FragmentManager fragmentManager;

    private ListView listView;

    // Key will be the item name, and the value will be the actual item. This way can pull up full activity from just the name
    private Map<String, GoodHabitItem> savedGoodHabits;

    private AppDatabase appDatabase;

    private ItemAdapter itemAdapter;

    //todo add ability to delete items, change items to GoodHabitItems
    // Clicking on items should open up a dialog where

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        savedGoodHabits = new HashMap<>();
        fragmentManager = getFragmentManager();
        setContentView(R.layout.good_habit_activity);
        listView = (ListView) findViewById(R.id.good_habit_list_view);
        // Makes press on item bring up an edit menu
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragment addGoodHabit = AddGoodHabitDialogFragment.newInstance((Item) listView.getItemAtPosition(position));
                addGoodHabit.show(fragmentManager, "addGoodHabit");
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });
        itemAdapter = new ItemAdapter(this, new ArrayList<Item>());
        fillListView(appDatabase.dao().getAllGoodHabits());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    fillListView(appDatabase.dao().getAllGoodHabits());
//                    itemAdapter.setListItems(Arrays.asList(appDatabase.dao().getAllGoodHabits()));
                }
            });
        }

    }



    public void addGoodHabit(View view) {
        Intent intent = new Intent(getApplicationContext(), AddGoodHabitActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, ADD_REQUEST_CODE);
    }

    private void fillListView(GoodHabitItem[] dbGoodHabits) {
        itemAdapter.clear();
        itemAdapter.addAll(Arrays.asList(dbGoodHabits));
        listView.setAdapter(itemAdapter);
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
                confirmDialog.show(fragmentManager, "confirmUpdate");
            }
        } else {
            finish();
            startActivity(getIntent());

        }
    }

}
