package com.youmu.scrollnestlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.youmu.scrollnestlayout.adapter.AssetItemAdapter;
import com.youmu.scrollnestlayout.adapter.TabPagerAdapter;
import com.youmu.scrollnestlayout.fragments.AssetIncomeFragment;
import com.youmu.scrollnestlayout.fragments.AssetIntoFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.top_pager)
    ViewPager topPager;
    @Bind(R.id.tabs_baby)
    PagerSlidingTabStrip tabsBaby;
    @Bind(R.id.pager_baby)
    ViewPager pagerBaby;

    private ArrayList<View> mPagerViewList = new ArrayList<View>();
    private ArrayList<Fragment> mFragmentsList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view1 = layoutInflater.inflate(R.layout.layout_item_asset, null);
        view1.findViewById(R.id.iv_pager_arrow_r).setVisibility(View.VISIBLE);
        mPagerViewList.add(view1);
        View view2 = layoutInflater.inflate(R.layout.layout_item_asset, null);
        view2.findViewById(R.id.iv_pager_arrow_l).setVisibility(View.VISIBLE);
        view2.findViewById(R.id.iv_pager_arrow_r).setVisibility(View.VISIBLE);
        mPagerViewList.add(view2);
        View view3 = layoutInflater.inflate(R.layout.layout_item_asset, null);
        view3.findViewById(R.id.iv_pager_arrow_l).setVisibility(View.VISIBLE);
        mPagerViewList.add(view3);

        AssetItemAdapter mAssetItemAdapter = new AssetItemAdapter(mPagerViewList);
        topPager.setAdapter(mAssetItemAdapter);

        mFragmentsList.add(new AssetIntoFragment());
        mFragmentsList.add(new AssetIncomeFragment());
        pagerBaby.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), mFragmentsList, new String[] { "每日赚取", "存入明细" }));
        tabsBaby.setViewPager(pagerBaby);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
