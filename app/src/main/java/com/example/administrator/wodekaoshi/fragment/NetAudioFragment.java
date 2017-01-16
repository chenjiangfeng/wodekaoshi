package com.example.administrator.wodekaoshi.fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.wodekaoshi.R;
import com.example.administrator.wodekaoshi.base.BaseFragment;
import com.example.administrator.wodekaoshi.bean.NetAudioBean;
import com.example.administrator.wodekaoshi.utils.CacheUtils;
import com.example.administrator.wodekaoshi.utils.Constants;
import com.google.gson.Gson;

import org.xutils.common.util.LogUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 陈江峰 on 2017/1/16.
 */

public class NetAudioFragment extends BaseFragment {
    /**
     * 初始化数据
     */


    private static final String TAG = NetAudioFragment.class.getSimpleName();

    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.tv_nomedia)
    TextView tvNomedia;


    private ListView listView;


    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_net_audio,null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initdata() {
       // super.initData();
       Log.e(TAG, "网络音频数据初始化了");
        String saveJson = CacheUtils.getString(mContext, Constants.NET_AUDIO_URL);
        if(!TextUtils.isEmpty(saveJson)){
            processData(saveJson);
        }
        getDataFromNet();
    }
    /**
     * 使用Gson解析json数据
     * @param
     * @return
     */
  private List<NetAudioBean.ListBean> parsedJson(String json) {
        NetAudioBean netAudioBean = new Gson().fromJson(json,NetAudioBean.class);
        return netAudioBean.getList();
    }


    private void processData(String saveJson) {

        NetAudioBean netAudioBean = paraseJson(saveJson);

        LogUtil.e(netAudioBean.getList().get(0).getText()+"-----------");

        List<NetAudioBean.ListBean> datas = netAudioBean.getList();

        if(datas != null && datas.size() >0){
            //有视频
            tvNomedia.setVisibility(View.GONE);
            //设置适配器
//            NetAudioFragmentAdapter myAdapter = new  NetAudioFragmentAdapter(mContext, datas);
//            listview.setAdapter(myAdapter);
        }else{
            //没有视频
            tvNomedia.setVisibility(View.VISIBLE);
        }

       progressbar.setVisibility(View.GONE);

    }

    private NetAudioBean paraseJson(String saveJson) {
        return new Gson().fromJson(saveJson,NetAudioBean.class);
    }


    @Override
    public void onRefrshData() {

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    public Object getDataFromNet() {
        return null;
    }
}
