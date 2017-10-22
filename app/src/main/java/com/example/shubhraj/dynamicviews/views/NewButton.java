package com.example.shubhraj.dynamicviews.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.example.shubhraj.dynamicviews.R;

/**
 * Created by Shubhraj on 22-10-2017.
 */

public class NewButton extends AppCompatButton{

    private Context mContext;

    public NewButton(Context context) {
        super(context);
        init(context);
    }

    public NewButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NewButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context)
    {
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(isPressed())
        {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_pressed, null));
        }
        else
        {
            setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_bckgrnd, null));
        }
        setTextColor(Color.parseColor("#eceff1"));
        super.onDraw(canvas);
    }
}
