package com.thundersoft.progector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class ProgectorHdmiSetting extends Activity implements OnClickListener {
		
		private LinearLayout btnBack = null;
		private RadioButton hdmiShutdown;
		private RadioButton hdmiIn;
		private RadioButton hdmiOut;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.progect_hdmi_setting);
			
			btnBack = (LinearLayout) findViewById(R.id.btn_back);
			btnBack.setOnClickListener(new onBack());
			hdmiShutdown = (RadioButton) findViewById(R.id.radio_shutdown);
			hdmiShutdown.setOnClickListener(this);
			hdmiShutdown.setChecked(true);
			hdmiIn = (RadioButton) findViewById(R.id.radio_hdmi_in);
			hdmiIn.setOnClickListener(this);
			hdmiOut = (RadioButton) findViewById(R.id.radio_hdmi_out);
			hdmiOut.setOnClickListener(this);
			
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.radio_shutdown:
//				hdmiShutdown.setChecked(true);
				break;

			default:
				break;
			}
			
		}
		
		public class onBack implements OnClickListener {
			public void onClick(View v) {
				ProgectorHdmiSetting.this.finish();
			}
		}
		

}
