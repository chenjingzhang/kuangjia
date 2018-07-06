package chz.com.dxt.demo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LikeFragment extends Fragment {
    public static LikeFragment newInstance(String s){
        LikeFragment likeFragment = new LikeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Like",s);
        likeFragment.setArguments(bundle);
        return likeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString("Like");
        TextView textView = (TextView) view.findViewById(R.id.like_tv);
        textView.setText(s);
        return view;
    }

}
