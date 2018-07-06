package chz.com.dxt.demo4;


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
        PersonFragment personFragment = new PersonFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Person",s);
        personFragment.setArguments(bundle);
        return personFragment;
    }

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString("Person");
        TextView textView = (TextView) view.findViewById(R.id.person_tv);
        textView.setText(s);
        return view;
    }

}
