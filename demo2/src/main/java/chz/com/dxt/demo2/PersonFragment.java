package chz.com.dxt.demo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    public static PersonFragment newInstance(String s){
        PersonFragment homeFragment = new PersonFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Person",s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString("Person");
        TextView textView = (TextView) view.findViewById(R.id.person_tv);
        textView.setText(s);
        return view;
    }

}
