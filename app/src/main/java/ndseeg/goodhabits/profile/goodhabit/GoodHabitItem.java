package ndseeg.goodhabits.profile.goodhabit;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.widget.CheckBox;

import java.util.Arrays;

import ndseeg.goodhabits.profile.AbstractItem;

@Entity(tableName = "goodhabititem")
@SuppressLint("ParcelCreator")
public class GoodHabitItem extends AbstractItem {

    @Ignore
    private final boolean inheritSuperIndices = true;

    @Ignore
    private boolean[] daysOfTheWeek;

    public boolean[] getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public GoodHabitItem() {
        super();
        daysOfTheWeek = new boolean[7];
    }

    public void setDaysOfTheWeek(boolean[] daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }

//    boolean inheritSuperIndices() {
//        return true;
//    }

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
