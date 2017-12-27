package ndseeg.goodhabits.profile.goodhabit;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

import java.util.Arrays;
import java.util.Objects;

import lombok.Getter;
import ndseeg.goodhabits.profile.AbstractItem;

@SuppressLint("ParcelCreator")
public class GoodHabitItem extends AbstractItem {


    @Getter
    private boolean[] daysOfTheWeek;

    public GoodHabitItem() {
        super();
        daysOfTheWeek = new boolean[7];
    }

    public void setDaysOfTheWeek(CheckBox[] checkBoxes) {
        for (int i = 0; i < checkBoxes.length; i++) {
            daysOfTheWeek[i] = checkBoxes[i].isChecked();
        }
    }

    public String toString() {
        return super.toString() + "Days of the Week=" + Arrays.toString(getDaysOfTheWeek());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodHabitItem)) return false;
        if (!super.equals(o)) return false;
        GoodHabitItem that = (GoodHabitItem) o;
        return Arrays.equals(getDaysOfTheWeek(), that.getDaysOfTheWeek());
    }
}
