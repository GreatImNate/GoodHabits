package ndseeg.goodhabits.profile;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ndseeg.goodhabits.R;

/**
 * Created by Nathan Seegmiller on 11/19/2017.
 */

public class GoalsFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.goals_fragment_layout, container, false);
    }

    public static GoalsFragment newInstance() {

        Bundle args = new Bundle();

        GoalsFragment fragment = new GoalsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
