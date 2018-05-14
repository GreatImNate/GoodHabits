package ndseeg.goodhabits.tracking;

import android.icu.util.Calendar;

import java.util.Date;


/**
 * Created by ndseeg on 12/8/17.
 */

public class WeeklyTracking {

    private Calendar calendar;

    //Instances of different weeks will be created on start of app. Whenever adding new GH or Goal it will retrieve the instance of correct week for when the date is
    // GH will have possible time ranges. If a GH has date ranges from 0-3 months, then it will store the goal in all the corresponding weeks
    public WeeklyTracking(Date trackingDate) {
        //

    }



}