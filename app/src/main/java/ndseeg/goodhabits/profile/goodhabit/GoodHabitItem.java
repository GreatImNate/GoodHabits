package ndseeg.goodhabits.profile.goodhabit;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

import java.util.Arrays;

import lombok.Getter;
import ndseeg.goodhabits.profile.AbstractItem;

@SuppressLint("ParcelCreator")
public class GoodHabitItem extends AbstractItem {

    public GoodHabitItem() {
        super();
        daysOfTheWeek = new boolean[7];
    }

    @Getter
    private boolean[] daysOfTheWeek;

    public void setDaysOfTheWeek(CheckBox[] checkBoxes) {
        for (int i = 0; i < checkBoxes.length; i++) {
            daysOfTheWeek[i] = checkBoxes[i].isChecked();
        }
    }

    public String toString() {
        return super.toString() + "Days of the Week=" + Arrays.toString(getDaysOfTheWeek());
    }
}
