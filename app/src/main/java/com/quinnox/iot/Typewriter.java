package com.quinnox.iot;

import android.content.Context;
import android.os.Handler;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by NikhilB on 5/12/2016.
 */
public class Typewriter extends TextView {

    private CharSequence mText;
    private int mIndex;
    private long mDelay = 550; //Default 500ms delay


    public Typewriter(Context context) {
        super(context);
    }

    public Typewriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            if (mIndex < mText.length()) {
            if (mText.charAt(mIndex) == ' ') {
                append(" ");
                mIndex++;
            } else {
                if (mIndex > 6 && mIndex < 13)
                    append(Html.fromHtml("<b><font color='#FFA500'>" + mText.charAt(mIndex++) + "</font></b>"));
                else
                    append(Html.fromHtml("<font color='#FFFFFF'>" + mText.charAt(mIndex++) + "</font>"));
            }

                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }
}