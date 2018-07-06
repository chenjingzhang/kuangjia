package chz.com.dxt.demo4;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/*使用LinearLayout + TextView实现了底部导航栏的效果 ViewPager+TabLayout
* */
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TextView mTextView;
    private List<String> mTabList = new ArrayList<>();
    private TabLayoutFragmentAdapter mAdapter;
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
        mAdapter = new TabLayoutFragmentAdapter(getSupportFragmentManager(), mTabList, this, mFragments, mTabImgs);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mAdapter.getTabView(i));
        }
        mTabLayout.addOnTabSelectedListener(this);
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
        mFragments.add(LocationFragment.newInstance(getString(R.string.item_location)));
        mFragments.add(LikeFragment.newInstance(getString(R.string.item_like)));
        mFragments.add(PersonFragment.newInstance(getString(R.string.item_person)));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setTabSelectedState(tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        setTabUnSelectedState(tab);
    }


    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void setTabSelectedState(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.tv_tab_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.iv_tab_icon);
        tabText.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        String s = tabText.getText().toString();
        if (getString(R.string.item_home).equals(s)) {
            tabIcon.setImageResource(R.drawable.home_fill);
        } else if (getString(R.string.item_location).equals(s)) {
            tabIcon.setImageResource(R.drawable.location_fill);
        } else if (getString(R.string.item_like).equals(s)) {
            tabIcon.setImageResource(R.drawable.like_fill);
        } else if (getString(R.string.item_person).equals(s)) {
            tabIcon.setImageResource(R.drawable.person_fill);
        }
    }

    private void setTabUnSelectedState(TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView tabText = (TextView) customView.findViewById(R.id.tv_tab_text);
        ImageView tabIcon = (ImageView) customView.findViewById(R.id.iv_tab_icon);
        tabText.setTextColor(ContextCompat.getColor(this, R.color.black_1));
        String s = tabText.getText().toString();
        if (getString(R.string.item_home).equals(s)) {
            tabIcon.setImageResource(R.drawable.home);
        } else if (getString(R.string.item_location).equals(s)) {
            tabIcon.setImageResource(R.drawable.location);
        } else if (getString(R.string.item_like).equals(s)) {
            tabIcon.setImageResource(R.drawable.like);
        } else if (getString(R.string.item_person).equals(s)) {
            tabIcon.setImageResource(R.drawable.person);
        }
    }
}
