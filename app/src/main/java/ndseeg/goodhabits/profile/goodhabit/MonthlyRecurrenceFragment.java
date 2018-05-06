package ndseeg.goodhabits.profile.goodhabit;

import android.app.Fragment;
import android.os.Bundle;

public class MonthlyRecurrenceFragment extends Fragment {

    public static MonthlyRecurrenceFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MonthlyRecurrenceFragment fragment = new MonthlyRecurrenceFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
