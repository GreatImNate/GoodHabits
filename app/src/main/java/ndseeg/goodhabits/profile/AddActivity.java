package ndseeg.goodhabits.profile;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import ndseeg.goodhabits.profile.goodhabit.GoodHabitItem;

/**
 * Created by ndseeg on 12/8/17.
 */

public abstract class AddActivity extends AppCompatActivity {

    private final Gson gson = new Gson();

    public String[] getItemsFromFile(String filename) {
        String[] items = {};
        try {
            File file = new File(getFilesDir(), filename);
            if (file.exists()) {
//                Log.d(TAG, "onCreate: Does this file ever exist?");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
//                Log.d(TAG, "onCreate: Reader reading" + sb.toString());
                String itemsString = sb.toString();
                items = itemsString.split("/");
//                Log.d(TAG, "onCreate: Splitting read items into individual items: " + Arrays.toString(items));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return items;
    }

    public static boolean confirmSelection(String selection) {
        return selection.equals("true");
    }

}
