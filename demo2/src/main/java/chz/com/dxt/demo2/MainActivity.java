package chz.com.dxt.demo2;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
/*使用LinearLayout + TextView实现了底部导航栏的效果
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTHome, mTLocation, mTLike, mTMe, mTextView;
    private HomeFragment mHomeFragment;
    private LocationFragment mLocationFragment;
    private LikeFragment mLikeFragment;
    private PersonFragment mPersonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.activity_text_view);
        mTHome = (TextView) findViewById(R.id.tv_home);
        mTLocation = (TextView) findViewById(R.id.tv_location);
        mTLike = (TextView) findViewById(R.id.tv_like);
        mTMe = (TextView) findViewById(R.id.tv_person);
        mTHome.setOnClickListener(this);
        mTLocation.setOnClickListener(this);
        mTLike.setOnClickListener(this);
        mTMe.setOnClickListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        switchFrgment(0);
        //set the defalut tab state
        setTabState(mTHome, R.drawable.home_fill, ContextCompat.getColor(this,R.color.colorPrimary));
    }

    @Override
    public void onClick(View v) {
        resetTabState();//reset the tab state
        switch (v.getId()) {
            case R.id.tv_home:
                setTabState(mTHome, R.drawable.home_fill, ContextCompat.getColor(this,R.color.colorPrimary));
                switchFrgment(0);
                break;
            case R.id.tv_location:
                setTabState(mTLocation, R.drawable.location_fill, ContextCompat.getColor(this,R.color.colorPrimary));
                switchFrgment(1);
                break;
            case R.id.tv_like:
                setTabState(mTLike, R.drawable.like_fill, ContextCompat.getColor(this,R.color.colorPrimary));
                switchFrgment(2);
                break;
            case R.id.tv_person:
                setTabState(mTMe, R.drawable.person_fill, ContextCompat.getColor(this,R.color.colorPrimary));
                switchFrgment(3);
                break;
        }
    }

    private void resetTabState() {
        setTabState(mTHome, R.drawable.home, ContextCompat.getColor(this,R.color.black_1));
        setTabState(mTLocation, R.drawable.location, ContextCompat.getColor(this,R.color.black_1));
        setTabState(mTLike, R.drawable.like, ContextCompat.getColor(this,R.color.black_1));
        setTabState(mTMe, R.drawable.person, ContextCompat.getColor(this,R.color.black_1));
        setTabState(mTMe, R.drawable.person, ContextCompat.getColor(this,R.color.black_1));
    }

    private void switchFrgment(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = mHomeFragment.newInstance(getString(R.string.item_home));
                }
                transaction.replace(R.id.sub_content, mHomeFragment);
                break;
            case 1:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance(getString(R.string.item_location));
                }
                transaction.replace(R.id.sub_content, mLocationFragment);
                break;
            case 2:
                if (mLikeFragment == null) {
                    mLikeFragment = LikeFragment.newInstance(getString(R.string.item_like));
                }
                transaction.replace(R.id.sub_content, mLikeFragment);
                break;
            case 3:
                if (mPersonFragment == null) {
                    mPersonFragment = PersonFragment.newInstance(getString(R.string.item_person));
                }
                transaction.replace(R.id.sub_content, mPersonFragment);
                break;
        }
        transaction.commit();
    }

    private void setTabState(TextView textView, int image, int color) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, image, 0, 0);//Call requires API level 17
        textView.setTextColor(color);
    }




}
