package com.youmu.scrollnestlayout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by youzehong on 15/12/3.
 */
public class NestViewPager extends ViewPager {
    private float xDistance, yDistance, lastX, lastY;

    public NestViewPager(Context context) {
        super(context);
    }

    public NestViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                lastX = ev.getX();
                lastY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();
                xDistance += Math.abs(curX - lastX);
                yDistance += Math.abs(curY - lastY) / 3; // favor X events
                lastX = curX;
                lastY = curY;
                if (xDistance > yDistance) {
                    return true;
                }
        }

        return super.onInterceptTouchEvent(ev);
    }

    //    public boolean shouldTouch(int direct) {
//        ViewGroup viewGroup;
//        if (getCurrentItem() == (getAdapter().getCount() - 1)) {
//            // 最后一个
//            viewGroup = (ViewGroup) getChildAt(getChildCount() - 1);
//        } else {
//            viewGroup = (ViewGroup) getChildAt(getChildCount() - 2);
//        }
//        for (int i = 0; i < viewGroup.getChildCount(); i++) {
//            View view = viewGroup.getChildAt(i);
//            if (view instanceof ListView) {
//
//            }
//        }
//
//    }
}
