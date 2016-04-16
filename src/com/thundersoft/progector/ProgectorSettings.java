package com.thundersoft.progector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thundersoft.progector.SetLightnessDialog.OnSelectLightnessListener;
import com.thundersoft.progector.TimePickerDialog.OnValuesPickerListener;

public class ProgectorSettings extends Activity implements OnClickListener{
	
	private LinearLayout btnBack = null;
	private RelativeLayout lightnessSetting;
	private Button wifiSetting;
	private Button keystoneCorrection;
	private Button hotspotSetting;
	private Button hdmiSetting;
	private Button apkFile;
	private Button languageSetting;
	private TextView tvLightness;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.progector_settings);
		
		btnBack = (LinearLayout) findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new onBack());
		wifiSetting = (Button) findViewById(R.id.progector_wifi_settings);
		wifiSetting.setOnClickListener(this);
		
		lightnessSetting = (RelativeLayout) findViewById(R.id.progector_lightness);
		lightnessSetting.setOnClickListener(this);
		
		keystoneCorrection = (Button) findViewById(R.id.keystone_correction);
		keystoneCorrection.setOnClickListener(this);
		
		hotspotSetting = (Button) findViewById(R.id.progector_hotspot_settings);
		hotspotSetting.setOnClickListener(this);
		
		hdmiSetting = (Button) findViewById(R.id.hdmi_advanced_settings);
		hdmiSetting.setOnClickListener(this);
		
		apkFile = (Button) findViewById(R.id.apk_file);
		apkFile.setOnClickListener(this);
		
		tvLightness = (TextView) findViewById(R.id.tv_lightness);
		
		languageSetting = (Button) findViewById(R.id.language_settings);
		languageSetting.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.progector_wifi_settings:
			intent.setClass(ProgectorSettings.this, ProgectorWifiSetting.class);
			startActivity(intent);
			break;
		case R.id.progector_hotspot_settings:
			TimePickerDialog dialog = new TimePickerDialog(
					ProgectorSettings.this);
			dialog.setOnValuesPickerListener(new OnValuesPickerListener() {

				public void onPickerValues(int hourValues, int secondValues) {
					// TODO Auto-generated method stub
					android.util.Log.d("MGJ", "hourValues:" + hourValues
							+ "      secondValues :" + secondValues);
				}
			});
			dialog.show();
			break;
		case R.id.progector_lightness:
			SetLightnessDialog  setLight = new SetLightnessDialog(ProgectorSettings.this, tvLightness);
			setLight.setOnLightnessListener(new OnSelectLightnessListener() {
				
				@Override
				public void onLightnessValues(String string) {
					// TODO Auto-generated method stub
					tvLightness.setText(string);
				}
			});
			 setLight.show();
			break;
		case R.id.keystone_correction:
			intent.setClass(ProgectorSettings.this, KeystoneCorrection.class);
			startActivity(intent);
			break;
		case R.id.hdmi_advanced_settings:
			intent.setClass(ProgectorSettings.this, ProgectorHdmiSetting.class);
			startActivity(intent);
			break;
		case R.id.apk_file:
			intent.setClass(ProgectorSettings.this, GetApkActivity.class);
			startActivity(intent);
			break;
		case R.id.language_settings:
			intent.setClass(ProgectorSettings.this, LanguageSettingsActivity.class);
			startActivity(intent);
			break;
//		case R.id.progector_wifi_settings:
//			intent.setClass(ProgectorSettings.this, ProgectorWifiSetting.class);
//			startActivity(intent);
//			break;
		default:
			break;
		}
	}
	
	public class onBack implements OnClickListener {
		public void onClick(View v) {
			ProgectorSettings.this.finish();
		}
	}
}
