package com.example.administrator.wodekaoshi.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 陈江峰 on 2017/1/16.
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext =getActivity();
    }

    /**
     * 当系统要创建Fragment的视图时调用这个方法
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }
    public abstract View initView();
    /**
     * 当Activity创建成功时回调这个方法
     *这个方法适合初始化数据
     * 联网请求
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
    }

    protected abstract void initdata();
    /**
     *
     * @param hidden false：当前类显示
     *               true:当前类隐藏
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("TAG","onHiddenChanged。。"+this.toString()+",hidden=="+hidden);
        if(!hidden){
            onRefrshData();
        }
    }
    /**
     * 当子类要刷新数据的时候重写该方法
     */

    protected abstract void onRefrshData();
}
