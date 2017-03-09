package com.example.rog.myapplication.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PullableScrollView2 extends ScrollView implements Pullable
{
	public boolean isCanPull = true;
	public PullableScrollView2(Context context)
	{
		super(context);
	}

	public PullableScrollView2(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public PullableScrollView2(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	@Override
	public boolean canPullDown()
	{
//		if (getScrollY() == 0)
//			return true;
//		else
			return false;
	}

	@Override
	public boolean canPullUp()
	{
		if(isCanPull) {
			if (getScrollY() >= (getChildAt(0).getHeight() - getMeasuredHeight()))
				return true;
			else
				return false;
		} else {
			return  false;
		}
	}

	@Override
	public void loadMoreComplate() {

	}

//	@Override
//	/**
//	 * 重写该方法，达到使ListView适应ScrollView的效果
//	 */
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
//				MeasureSpec.AT_MOST);
//		super.onMeasure(widthMeasureSpec, expandSpec);
//	}

}
