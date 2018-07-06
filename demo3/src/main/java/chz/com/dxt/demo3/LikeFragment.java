package chz.com.dxt.demo3;


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

    public static LikeFragment newInstance(String s){
        LikeFragment homeFragment = new LikeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Like",s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    public LikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_content, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString("Like");
        TextView textView = (TextView) view.findViewById(R.id.fragment_text_view1);
        textView.setText(s);
        return view;
    }

}
