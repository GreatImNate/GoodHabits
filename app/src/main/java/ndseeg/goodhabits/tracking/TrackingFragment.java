package ndseeg.goodhabits.tracking;

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

public class TrackingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tracking_fragment_layout, container, false);
    }

    public static TrackingFragment newInstance() {

        Bundle args = new Bundle();

        TrackingFragment fragment = new TrackingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
