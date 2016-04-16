package com.thundersoft.progector;

import java.util.ArrayList;
import java.util.TimeZone;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;


public class ZonePicker extends Activity {
		
		
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE); // 去掉标题栏
			setContentView(R.layout.date_zone_select);
			ArrayAdapter <CharSequence> adapter =
			          new ArrayAdapter <CharSequence> (this, android.R.layout.simple_spinner_item );
			    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			    String[]TZ = TimeZone.getAvailableIDs();
			    ArrayList<String> TZ1 = new ArrayList<String>();
			    for(int i = 0; i < TZ.length; i++) {
			        if(!(TZ1.contains(TimeZone.getTimeZone(TZ[i]).getDisplayName()))) {
			            TZ1.add(TimeZone.getTimeZone(TZ[i]).getDisplayName());
			        }
			    }
			    for(int i = 0; i < TZ1.size(); i++) {
			        adapter.add(TZ1.get(i));
			    }
			    final Spinner TZone = (Spinner)findViewById(R.id.TimeZoneEntry);
			    TZone.setAdapter(adapter);
			    for(int i = 0; i < TZ1.size(); i++) {
			        if(TZ1.get(i).equals(TimeZone.getDefault().getDisplayName())) {
			            TZone.setSelection(i);
			        }
			    }
			
			
		}
}
