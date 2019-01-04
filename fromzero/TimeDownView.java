package com.example.a86131.fromzero;


import android.content.Context;

import android.content.res.TypedArray;

import android.graphics.Color;

import android.os.CountDownTimer;

import android.support.annotation.Nullable;

import android.util.AttributeSet;

import android.widget.LinearLayout;

import android.widget.TextView;



import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.TimeZone;



import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;



/**

 *

 * 倒计时控件

 */

public class TimeDownView extends LinearLayout {

    private Context mContext;

    private static final String TIME = "mm:ss";

    private static final String MILLION = "S";

    private String time = "00:00:00";

    private String million = "0";

    private CountDownTimer downTimer;

    private DateFormat df, df2;

    private TextView mText, mText2;



    private int txtColor,  txtSize;

    private int txtMillionColor, txtMillionBg, txtMillionSize;

    private boolean millionShow = false;

    private boolean isTimeDownOver = false;

    private long millisSeconds = 0;



    public TimeDownView(Context context) {

        super(context);

        initView(context, null);

    }



    public TimeDownView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        initView(context, attrs);

    }



    public TimeDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);



        initView(context, attrs);

    }



    private void initView(Context context, AttributeSet attrs) {

        mContext = context;



        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TimeView);

        millionShow = ta.getBoolean(R.styleable.TimeView_million_show, false);

        txtColor = ta.getInt(R.styleable.TimeView_txt_color, Color.BLACK);


        txtSize = ta.getInt(R.styleable.TimeView_txt_size, 30);





        mText = new TextView(mContext);


        mText.setTextSize(txtSize);


        mText.setText(time);



        addView(mText);

        df = createDateFormat(TIME);


        if (millionShow) {
            txtMillionColor = ta.getInt(R.styleable.TimeView_txt_million_color, Color.BLACK);
            txtMillionBg = ta.getInt(R.styleable.TimeView_txt_million_bg, Color.WHITE);
            txtMillionSize = ta.getInt(R.styleable.TimeView_txt_million_size, 30);
            df2 = createDateFormat(MILLION);



            mText2 = new TextView(mContext);
            mText2.setTextColor(txtMillionColor);
            mText2.setTextSize(txtMillionSize);
            mText2.setText(million);
            mText2.setPadding(5, 0, 5, 0);



            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
            params.leftMargin = 10;
            mText2.setLayoutParams(params);
            addView(mText2);
        }
    }



    public void startTime(long timeMillionMiao) {
        if (timeMillionMiao < 1000) {
            isTimeDownOver = true;
            invalidate(0);
            return;
        }

        if (downTimer != null) {
            downTimer.onFinish();
            downTimer.cancel();
        }

        downTimer = new CountDownTimer(timeMillionMiao, millionShow ? 100 : 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                isTimeDownOver = false;
                invalidate(millisUntilFinished);
            }



            @Override
            public void onFinish() {
                isTimeDownOver = true;
                invalidate(0);
            }
        }.start();
    }



    public void invalidate(long millisSeconds) {
        this.millisSeconds = millisSeconds;
        mText.setText(formatTime(millisSeconds));


        if (millionShow) {

            Date date = new Date(millisSeconds);

            mText2.setText(df2.format(date));
        }
    }



    private DateFormat createDateFormat(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        TimeZone gmt = TimeZone.getTimeZone("GMT");//关键所在
        sdf.setTimeZone(gmt);
        sdf.setLenient(true);
        return sdf;

    }

    /**

     * 毫秒转化时分秒

     */
    public static String formatTime(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;
        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        hour = day * 24 + hour;
        String strDay = day < 10 ? "0" + day : "" + day; //天

        String strHour = hour < 10 ? "0" + hour : "" + hour;//小时

        String strMinute = minute < 10 ? "0" + minute : "" + minute;//分钟
        String strSecond = second < 10 ? "0" + second : "" + second;//秒
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;//毫秒
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
        return strHour + ":" + strMinute + ":" + strSecond;

    }
    public boolean isTimeDownOver() {
        return isTimeDownOver;
    }

    public long getMillisSeconds() {
        return millisSeconds;
    }

}

