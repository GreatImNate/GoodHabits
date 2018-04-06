package ndseeg.goodhabits.profile;


import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

@Data
public abstract class AbstractItem implements Parcelable, Item {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    String name;
    String description;

    // For GHs values will be 1-5 or some number that doing the habit will give
    // For Goals the value will represent the points that you need to accumulate to
    int value;


}
