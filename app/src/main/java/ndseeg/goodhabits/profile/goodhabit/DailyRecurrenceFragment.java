package ndseeg.goodhabits.profile.goodhabit;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ndseeg.goodhabits.R;

public class DailyRecurrenceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recurrence_layout_daily, container, false);
    }

    public static DailyRecurrenceFragment newInstance() {

        Bundle args = new Bundle();

        DailyRecurrenceFragment fragment = new DailyRecurrenceFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
