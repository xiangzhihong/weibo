package com.xzh.weibopopwindows.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.xzh.weibopopwindows.R;
import com.xzh.weibopopwindows.utils.Contants;
import com.xzh.weibopopwindows.utils.SharedUtil;
import com.xzh.weibopopwindows.widght.MoreWindow;

public class MainActivity extends Activity {

	private Context context;
	private ImageView image;
	private MoreWindow mMoreWindow;
	private View guide;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		context=MainActivity.this;
		init();
		guide();
	}

	private void guide() {
            boolean flag= SharedUtil.newInstance(this).getBoolean(Contants.GUIDE,false);
		  if(flag){
			  guide.setVisibility(View.GONE);
		  }else{
			  guide.setVisibility(View.VISIBLE);
		  }
	}

	private void init() {
		image = (ImageView) findViewById(R.id.show);
		guide=findViewById(R.id.main_guide);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showMoreWindow(v);
			}
		});
		guide.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				guide.setVisibility(View.GONE);
				SharedUtil.newInstance(context).set(Contants.GUIDE,true);
			}
		});
	}

	private void showMoreWindow(View view) {
		if (null == mMoreWindow) {
			mMoreWindow = new MoreWindow(this);
			mMoreWindow.init();
		}

		mMoreWindow.showMoreWindow(view,100);
	}

}
