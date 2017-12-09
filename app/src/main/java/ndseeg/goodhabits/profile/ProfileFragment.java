package ndseeg.goodhabits.profile;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ndseeg.goodhabits.R;

/**
 * Created by Nathan Seegmiller on 11/19/2017.
 */

public class ProfileFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        final Button button = (Button) getActivity().findViewById(R.id.add_good_habit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddGoodHabitActivity.class));
            }
        });
        return inflater.inflate(R.layout.goals_fragment_layout, container, false);
    }

    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.add_good_habit:
//                startActivity(new Intent(this.getActivity(), AddGoodHabitActivity.class));
//        }
//    }
}
