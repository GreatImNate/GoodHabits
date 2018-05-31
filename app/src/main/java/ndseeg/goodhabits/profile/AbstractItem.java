package ndseeg.goodhabits.profile;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import android.support.annotation.NonNull;

@Entity
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

    @PrimaryKey
    @NonNull
    private String name;

    private String description;

    private int value;

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


    @Override
    public String toString() {
        return "AbstractItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                '}';
    }


}
