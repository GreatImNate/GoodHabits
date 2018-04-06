package ndseeg.goodhabits.utils;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Created by ndseeg on 12/25/17.
 */

public class FileHandler {

    private final Gson gson = new Gson();

    public static String[] getItemsFromFile(final String filename, final Context context) {
        String[] items = {};
        try {
            File file = new File(context.getFilesDir() ,filename);
            if (file.exists()) {
//                Log.d(TAG, "onCreate: Does this file ever exist?");
                BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
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

}
