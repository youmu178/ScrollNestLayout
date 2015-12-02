package com.youmu.scrollnestlayout.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by youzehong on 15/11/30.
 */
public class AssetItemAdapter extends PagerAdapter {
    private ArrayList<View> mPagerViewList;

    public AssetItemAdapter(ArrayList<View> pagerViewList) {
        super();
        this.mPagerViewList = pagerViewList;
    }

    @Override
    public int getCount() {
        return mPagerViewList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mPagerViewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mPagerViewList.get(position));
        return mPagerViewList.get(position);

    }
}
