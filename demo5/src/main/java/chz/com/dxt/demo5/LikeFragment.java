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
public class LikeFragment extends Fragment {
    public static LikeFragment newInstance(String s) {
        LikeFragment fragment = new LikeFragment();
        Bundle args = new Bundle();
        args.putString("Like",s);
        fragment.setArguments(args);
        return fragment;
    }


    public LikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        Bundle bundle = getArguments();
        String s  = bundle.getString("Like");
        TextView textView  = (TextView) view.findViewById(R.id.like_tv);
        textView.setText(s);
        return view;
    }

}
