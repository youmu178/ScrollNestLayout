package com.youmu.scrollnestlayout.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by youzehong on 15/11/30.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int viewId = onGetViewId();
        if (viewId > 0) {
            View layout = inflater.inflate(viewId, null, false);
            ButterKnife.bind(this, layout);

            return layout;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract int onGetViewId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
