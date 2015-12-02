package com.youmu.scrollnestlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.youmu.scrollnestlayout.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by youzehong on 15/11/30.
 */
public class ItemAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private ArrayList<String> mList;

    public ItemAdapter(Context context, ArrayList<String> mList) {
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String str = (String) getItem(position);
        holder.mTv.setText(str);
        return convertView;
    }

    public class ViewHolder {
        @Bind(R.id.textView)
        TextView mTv;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
