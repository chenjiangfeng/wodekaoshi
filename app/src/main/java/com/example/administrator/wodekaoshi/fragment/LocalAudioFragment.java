package com.example.administrator.wodekaoshi.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.wodekaoshi.base.BaseFragment;

/**
 * Created by 陈江峰 on 2017/1/16.
 */

public class LocalAudioFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        textView.setText("本地音乐");
        return textView;
    }

    @Override
        public void initdata() {


    }

    @Override
    public void onRefrshData() {

    }
}
