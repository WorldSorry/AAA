package com.example.rog.myapplication.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by ROG on 2016/1/4.
 */
public class PullableRelativeLayout extends RelativeLayout implements Pullable{
    public PullableRelativeLayout(Context context)
    {
        super(context);
    }

    public PullableRelativeLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullableRelativeLayout(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown()
    {
        return true;
    }

    @Override
    public boolean canPullUp()
    {
        return true;
    }

    @Override
    public void loadMoreComplate() {

    }
}
