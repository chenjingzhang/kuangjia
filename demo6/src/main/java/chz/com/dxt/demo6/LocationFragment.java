package chz.com.dxt.demo6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends Fragment {
    public static LocationFragment newInstance(String s) {
        LocationFragment homeFragment = new LocationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Location", s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    public LocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        Bundle bundle = getArguments();
        String s = bundle.getString("Location");
        TextView textView = (TextView) view.findViewById(R.id.location_tv);
        textView.setText(s);
        return view;
    }
}
