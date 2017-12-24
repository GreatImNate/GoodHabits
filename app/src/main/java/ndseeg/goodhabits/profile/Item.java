package ndseeg.goodhabits.profile;


import android.os.Parcelable;

public interface Item extends Parcelable{

    void setValue(int value);
    int getValue();

    void setName(String name);
    String getName();

    void setDescription(String Description);
    String getDescription();

}
