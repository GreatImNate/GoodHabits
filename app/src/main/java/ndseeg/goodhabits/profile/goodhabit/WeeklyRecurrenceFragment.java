package ndseeg.goodhabits.profile.goodhabit;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ndseeg.goodhabits.R;

public class WeeklyRecurrenceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recurrence_layout_weekly, container, false);
    }
    public static WeeklyRecurrenceFragment newInstance() {

        Bundle args = new Bundle();

        WeeklyRecurrenceFragment fragment = new WeeklyRecurrenceFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
