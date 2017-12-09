package ndseeg.goodhabits.tracking;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;

import java.util.Date;

import ndseeg.goodhabits.R;

public class TrackingFragment extends Fragment {

    private final static String TAG = "CALENDAR_FRAGMENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        CalendarView calendarView = new CalendarView(this.getActivity());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.d(TAG, String.format("onDateSet: Year: %d, Month %d, Day: %d", year,month,dayOfMonth));

            }
        });
        return calendarView;
    }

    public static TrackingFragment newInstance() {

        Bundle args = new Bundle();

        TrackingFragment fragment = new TrackingFragment();
        fragment.setArguments(args);
        return fragment;
    }



}
