package com.youmu.scrollnestlayout.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.youmu.scrollnestlayout.R;
import com.youmu.scrollnestlayout.ScrollNestLayout;
import com.youmu.scrollnestlayout.adapter.ItemAdapter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by youzehong on 15/11/30.
 */
public class AssetIncomeFragment extends BaseFragment {
    @Bind(R.id.lv_list)
    ListView lvList;
    private ArrayList<String> mList = new ArrayList<>();

    @Override
    protected int onGetViewId() {
        return R.layout.fragment_list;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < 30; i++) {
            mList.add("Income  " + i);
        }
        lvList.setAdapter(new ItemAdapter(getActivity(), mList));

        lvList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                ScrollNestLayout.sInternalScrollY = ViewCompat.canScrollVertically(lvList, -1);
                Log.e("abc", "onScroll: " + firstVisibleItem);
                ScrollNestLayout.sInternalScrollY = firstVisibleItem <= 1;
            }
        });

    }
}
