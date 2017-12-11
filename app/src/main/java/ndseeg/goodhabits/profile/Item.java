package ndseeg.goodhabits.profile;


import android.os.Parcelable;

import lombok.Data;

@Data
public abstract class Item implements Parcelable{
    String name;
    String description;

    // For GHs values will be 1-5 or some number that doing the habit will give
    // For Goals the value will represent the points that you need to accumulate to
    int value;


}
