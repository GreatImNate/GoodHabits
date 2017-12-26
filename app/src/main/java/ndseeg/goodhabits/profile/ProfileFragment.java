package ndseeg.goodhabits.profile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ndseeg.goodhabits.R;
import ndseeg.goodhabits.profile.goals.GoalsActivity;
import ndseeg.goodhabits.profile.goodhabit.GoodHabitActivity;

/**
 * Created by Nathan Seegmiller on 11/19/2017.
 */

public class ProfileFragment extends Fragment {

    private final FragmentManager fragmentManager = getFragmentManager();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        //        return super.onCreateView(inflater, container, savedInstanceState);
        final Button button = (Button) view.findViewById(R.id.good_habit_launch_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GoodHabitActivity.class));
            }
        });

        final Button goalsButton = (Button) view.findViewById(R.id.goals_button_launch_activity);
        goalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GoalsActivity.class));
            }
        });
    }

    public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
