package chz.com.dxt.demo5;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/* 有问题。
* */
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TextView mTextView;
    private List<String> mTabList = new ArrayList<>();
    private TabLayoutFragment2Adapter mAdapter;
    private int[] mTabImgs = new int[]{R.drawable.home, R.drawable.location, R.drawable.like, R.drawable.person};
    private List<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragmentList();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        initTabList();
        mAdapter = new TabLayoutFragment2Adapter(getSupportFragmentManager(), mTabList, this, mFragments, mTabImgs);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addOnTabSelectedListener(this);

        mTabLayout.getTabAt(0).setIcon(R.drawable.home_fill);
        mTabLayout.getTabAt(1).setIcon(R.drawable.location);
        mTabLayout.getTabAt(2).setIcon(R.drawable.like);
        mTabLayout.getTabAt(3).setIcon(R.drawable.person);

    }
    private void initTabList() {
        mTabList.clear();
        mTabList.add(getString(R.string.item_home));
        mTabList.add(getString(R.string.item_location));
        mTabList.add(getString(R.string.item_like));
        mTabList.add(getString(R.string.item_person));
    }
    private void initFragmentList() {
        mFragments.clear();
        mFragments.add(HomeFragment.newInstance(getString(R.string.item_home)));
        mFragments.add(LocalFragment.newInstance(getString(R.string.item_location)));
        mFragments.add(LikeFragment.newInstance(getString(R.string.item_like)));
        mFragments.add(PersonFragment.newInstance(getString(R.string.item_person)));
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        resetTabIcon();
        int position = tab.getPosition();
        Log.e("Kevin", "position--->" + position);
        switch (position) {
            case 0:
                tab.setIcon(R.drawable.home_fill);
                break;
            case 1:
                tab.setIcon(R.drawable.location_fill);
                break;
            case 2:
                tab.setIcon(R.drawable.like_fill);
                break;
            case 3:
                tab.setIcon(R.drawable.person_fill);
                break;

        }
    }

    private void resetTabIcon() {
        mTabLayout.getTabAt(0).setIcon(R.drawable.home);
        mTabLayout.getTabAt(1).setIcon(R.drawable.location);
        mTabLayout.getTabAt(2).setIcon(R.drawable.like);
        mTabLayout.getTabAt(3).setIcon(R.drawable.person);
    }


    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
