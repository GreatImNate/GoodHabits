package ndseeg.goodhabits.profile.goodhabit;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

import java.util.Arrays;

import lombok.Getter;
import ndseeg.goodhabits.profile.AbstractItem;

/**
 * Created by Nathan Seegmiller on 11/19/2017.
 */

@SuppressLint("ParcelCreator")
public class GoodHabitItem extends AbstractItem implements Parcelable {

    public GoodHabitItem() {
        super();
        daysOfTheWeek = new boolean[7];
    }

    @Getter
    private boolean[] daysOfTheWeek;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public void setDaysOfTheWeek(CheckBox[] checkBoxes) {
        for (int i = 0; i < checkBoxes.length; i++) {
            daysOfTheWeek[i] = checkBoxes[i].isChecked();
        }
    }

    public String toString() {
        return super.toString() + "Days of the Week=" + Arrays.toString(getDaysOfTheWeek());
    }
}
