package ndseeg.goodhabits.profile;


import android.os.Parcel;
import android.os.Parcelable;


public abstract class AbstractItem implements Parcelable, Item {


    public AbstractItem(String name, String description, int value) {
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public AbstractItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    private String description;

    // For GHs values will be 1-5 or some number that doing the habit will give
    // For Goals the value will represent the points that you need to accumulate to
    private int value;


}
