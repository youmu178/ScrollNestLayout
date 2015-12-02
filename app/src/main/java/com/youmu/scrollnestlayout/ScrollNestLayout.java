package com.youmu.scrollnestlayout;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by youzehong on 15/11/29.
 */
public class ScrollNestLayout extends ScrollView {

    public static boolean sInternalScrollY = true;

    private int mScrollViewHeight;
    private View mViewPager;
    private float mDownY;
    private float mDownX;

    public ScrollNestLayout(Context context) {
        this(context, null);
    }

    public ScrollNestLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollNestLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            this.setOnScrollChangeListener(new OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//                }
//            });
//        }

        postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollTo(0, 0);
            }
        }, 2000);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mScrollViewHeight = getHeight();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mViewPager = ((ViewGroup) getChildAt(0)).getChildAt(2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight = getMeasuredHeight();
        mViewPager.getLayoutParams().height = measuredHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("", "measuredHeight " + measuredHeight);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

    }

    boolean flag;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                mDownX = ev.getX();
                flag = false;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("abc", "onInterceptTouchEvent: " + (ev.getY() - mDownY));
                if (ev.getY() > mDownY) {
                    flag = true;
                }
                break;
        }

        Log.e("abc", "onInterceptTouchEvent: " + sInternalScrollY);
        Log.e("abc", "flag: " + flag);
        if (!(flag && sInternalScrollY) && !ViewCompat.canScrollVertically(this, 1)) {
//            sInternalScrollY = false;
            return false;
        } else {
//            return true;
            return super.onInterceptTouchEvent(ev);
        }

    }

}
