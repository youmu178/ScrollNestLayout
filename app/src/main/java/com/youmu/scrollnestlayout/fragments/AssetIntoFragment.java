package com.youmu.scrollnestlayout.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.youmu.scrollnestlayout.R;
import com.youmu.scrollnestlayout.adapter.ItemAdapter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by youzehong on 15/11/30.
 */
public class AssetIntoFragment extends BaseFragment {

    @Bind(R.id.lv_list)
    ListView lvList;
//    @Bind(R.id.refreshLayout)
//    SwipeRefreshLayout refreshLayout;
    private ArrayList<String> mList = new ArrayList<>();

    @Override
    protected int onGetViewId() {
        return R.layout.fragment_list;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < 5; i++) {
            mList.add("Into  " + i);
        }
        lvList.setAdapter(new ItemAdapter(getActivity(), mList));
    }
}
