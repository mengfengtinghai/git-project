package com.thundersoft.progector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ProgectorMoreActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 去掉标题栏
		setContentView(R.layout.pop_progector_more);
		LinearLayout btnVoice = (LinearLayout) findViewById(R.id.project_voice);
		btnVoice.setOnClickListener(this);
		LinearLayout btnHdmi = (LinearLayout) findViewById(R.id.progect_start_hdmi);
		btnHdmi.setOnClickListener(this);
		LinearLayout btnMiracast = (LinearLayout) findViewById(R.id.progect_miracast);
		btnMiracast.setOnClickListener(this);
		LinearLayout btnSetting = (LinearLayout) findViewById(R.id.progect_setting);
		btnSetting.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.project_voice:
			intent.putExtra("result", "1");
			setResult(1, intent);
			break;
		case R.id.progect_start_hdmi:
			
			break;
		case R.id.progect_miracast:
			intent.setClass(ProgectorMoreActivity.this, ZonePicker.class);
			startActivity(intent);
			break;
		case R.id.progect_setting:
			intent.setAction("com.thundersoft.progector.settings");
			startActivity(intent);
			break;
		default:
			break;
		}
	finish();
	}
}
