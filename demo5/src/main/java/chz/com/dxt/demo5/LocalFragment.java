package chz.com.dxt.demo5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocalFragment extends Fragment {
    public static LocalFragment newInstance(String s) {
        LocalFragment fragment = new LocalFragment();
        Bundle args = new Bundle();
        args.putString("Local",s);
        fragment.setArguments(args);
        return fragment;
    }

    public LocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_local, container, false);
        Bundle bundle = getArguments();
        String s  = bundle.getString("Local");
        TextView textView  = (TextView) view.findViewById(R.id.local_tv);
        textView.setText(s);
        return view;
    }

}
