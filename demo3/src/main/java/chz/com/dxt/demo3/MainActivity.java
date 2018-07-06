package chz.com.dxt.demo3;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/*
* 1.使用LinearLayout + TextView实现了底部导航栏的效果
  2.使用RadioGroup + RadioButton实现了底部导航栏的效果 ***************
  3.利用BottomNavigationBar实现底部导航栏
* */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private TextView mTextView;
    private RadioButton mRadioHome, mRadioLocation, mRadioLike, mRadioMe;
    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment;
    private LocationFragment mLocationFragment;
    private LikeFragment mLikeFragment;
    private PersonFragment mPersonFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setDefaultFragment();
    }


    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mRadioHome = (RadioButton) findViewById(R.id.rb_home);
        mRadioLocation = (RadioButton) findViewById(R.id.rb_location);
        mRadioLike = (RadioButton) findViewById(R.id.rb_like);
        mRadioMe = (RadioButton) findViewById(R.id.rb_me);
        mRadioGroup.setOnCheckedChangeListener(this);
    }


    private void setDefaultFragment() {
        mRadioHome.setChecked(true);
        mRadioLocation.setChecked(false);
        mRadioLike.setChecked(false);
        mRadioMe.setChecked(false);
        if (mRadioHome.isChecked()) {
            setTabState();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            mHomeFragment = HomeFragment.newInstance(getString(R.string.item_home));
            transaction.replace(R.id.sub_content, mHomeFragment).commit();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.rb_home:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance(getString(R.string.item_home));
                }
                transaction.replace(R.id.sub_content, mHomeFragment);
                break;
            case R.id.rb_location:
                if (mLocationFragment == null) {
                    mLocationFragment = LocationFragment.newInstance(getString(R.string.item_location));
                }
                transaction.replace(R.id.sub_content, mLocationFragment);
                break;
            case R.id.rb_like:
                if (mLikeFragment == null) {
                    mLikeFragment = LikeFragment.newInstance(getString(R.string.item_like));
                }
                transaction.replace(R.id.sub_content, mLikeFragment);
                break;
            case R.id.rb_me:
                if (mPersonFragment == null) {
                    mPersonFragment = PersonFragment.newInstance(getString(R.string.item_person));
                }
                transaction.replace(R.id.sub_content, mPersonFragment);
                break;
        }
        setTabState();
        transaction.commit();
    }

    private void setTabState() {
        setHomeState();
        setLocationState();
        setLikeState();
        setMeState();

    }

    private void setHomeState() {
        if (mRadioHome.isChecked()) {
            mRadioHome.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioHome.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setLocationState() {
        if (mRadioLocation.isChecked()) {
            mRadioLocation.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioLocation.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setLikeState() {
        if (mRadioLike.isChecked()) {
            mRadioLike.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioLike.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }

    private void setMeState() {
        if (mRadioMe.isChecked()) {
            mRadioMe.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            mRadioMe.setTextColor(ContextCompat.getColor(this, R.color.black));
        }
    }
}
