package ndseeg.goodhabits.profile.goodhabit;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.Item;

public class GoodHabitActivity extends AppCompatActivity implements AddGoodHabitDialogFragment.OnCompleteListener {

    private final String TAG = "GoodHabitActivity";

    private final String goodHabitFilename = "goodhabit";

    private FragmentManager fragmentManager;

    private ListView listView;

    // Key will be the item name, and the value will be the actual item. This way can pull up full activity from just the name
    private Map<String, GoodHabitItem> savedGoodHabits;

    private ArrayList<GoodHabitItem> goodHabitItems;

    //todo add ability to delete items, change items to GoodHabitItems

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goodHabitItems = new ArrayList<>();
        fragmentManager = getFragmentManager();
        setContentView(R.layout.good_habit_activity);
        listView = (ListView) findViewById(R.id.good_habit_list_view);
        try  {
            File file = new File(getFilesDir(), goodHabitFilename);
            if (file.exists()) {
                Log.d(TAG, "onCreate: Does this file ever exist?");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                Log.d(TAG, "onCreate: Reader reading" + sb.toString());
                String itemsString = sb.toString();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addGoodHabit(View view) {
        DialogFragment addGoodHabit = AddGoodHabitDialogFragment.newInstance(null);
        addGoodHabit.setTargetFragment(addGoodHabit, 1);
        addGoodHabit.show(fragmentManager, "addGoodHabit");

    }


    private void writeOutItem(final Item item) {
        GoodHabitItem goodHabitItem = (GoodHabitItem) item;
        try (OutputStreamWriter writer = new OutputStreamWriter(openFileOutput(goodHabitFilename, Context.MODE_APPEND))) {
            Gson gson = new Gson();
            String json = gson.toJson(goodHabitItem);
            writer.append(json);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete(final Item item) {
        Log.i(TAG, "onComplete: User entered in item to be saved");
        // Todo try append mode instead of private, find some way to not override values in file
        writeOutItem(item);
        finish();
        startActivity(getIntent());
    }
}
