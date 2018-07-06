package chz.com.dxt.demo5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(String s) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("Home",s);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle bundle = getArguments();
        String s  = bundle.getString("Home");
        TextView textView  = (TextView) view.findViewById(R.id.home_tv);
        textView.setText(s);
        return textView;
    }


}
