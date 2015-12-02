package com.youmu.scrollnestlayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> fragmentsList;
    private String[] titles;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    
    public TabPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList, String [] titles) {
		super(fm);
		this.fragmentsList = fragmentsList;
		this.titles = titles;
	}
    
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

}
