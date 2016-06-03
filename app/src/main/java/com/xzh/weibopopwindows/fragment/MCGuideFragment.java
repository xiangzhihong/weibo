package com.xzh.weibopopwindows.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xzh.weibopopwindows.R;
import com.xzh.weibopopwindows.widght.MCVideoView;

/**
 * Created by xiangzhihong on 2015/12/3 on 16:34.
 */
public class MCGuideFragment extends Fragment {

    private View mBgView;
    private Context mContext;
    private MCVideoView mVideoView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View localView = inflater.inflate(R.layout.guide_item_layout, null);
        initView(localView);
        return localView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initView(View localView) {
        mVideoView = ((MCVideoView) localView.findViewById(R.id.videoview));
        mBgView = localView.findViewById(R.id.guide_bg);
    }

    private void initData() {
        Bundle localBundle = getArguments();
        int i = 0;
        int j = 0;
        int k = 0;
        if ((localBundle != null) && (localBundle.containsKey("index")))
            i = localBundle.getInt("index");
        try {
            String str = "guide_" + i;
            j = R.raw.class.getDeclaredField(str).getInt(this);
            int l = R.drawable.class.getDeclaredField(str).getInt(this);
            Log.d("MCGuideFragment", "MCGuideFragment 视频id:" + j);
            k = l;
            if (j != 0)
                mVideoView.playVideo(mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + j));
                Log.d("MCGuideFragment", "当前播放 MCGuideFragment:" + j);
            if (k != 0)
                mBgView.setBackgroundResource(k);
            return;
        } catch (Exception localException) {
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mVideoView == null)
            return;
        this.mVideoView.stopPlayback();
    }
}
