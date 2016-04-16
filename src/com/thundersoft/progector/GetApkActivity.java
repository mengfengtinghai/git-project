package com.thundersoft.progector;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class GetApkActivity extends Activity {
		
		private LinearLayout btnBack = null;
		private ListView listView = null;
		private List<Map<String, Object>> mApkList;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.activity_get_apk);
			
			btnBack = (LinearLayout) findViewById(R.id.btn_back);
			btnBack.setOnClickListener(new onBack());
			listView = (ListView) findViewById(R.id.list_apk_file);
			mApkList = new ArrayList<Map<String, Object>>();
			mApkList.clear();
			
			File sdFile = Environment.getDataDirectory();
			File sysFile = Environment.getRootDirectory();
			File inFile = Environment.getExternalStorageDirectory();
//			String inPath = Environment.getExternalStorageDirectory() + File.separator;
			
			
			android.util.Log.d("MGJ", "infile:"  + inFile   + "\n"  +  "sdFile" + sdFile +  "\n"  + "sysFile" + sysFile );
			spkList( sysFile );
			spkList( sdFile );
//			spkList( inFile );
			
			SimpleAdapter adapter = new SimpleAdapter(GetApkActivity.this, mApkList, R.layout.item_apk_file, new String[] { "apk_name" }, new int[] {
				R.id.item_apk });
			listView.setAdapter(adapter);
		}
		
	public void spkList(File file) {
		if (file != null) {
			if (file.isDirectory()) {
				
				File[] listFile = file.listFiles();
				if (listFile != null) {
					for (int i = 0; i < listFile.length; i++) {
						spkList(listFile[i]);// 递归，直到把所有文件遍历完
					}
				}
			} else {
				String fileName = file.getAbsolutePath();
				String name = file.getName();				
				if(fileName.endsWith(".apk")){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("apk_name", name);
					map.put("path", fileName);
//					android.util.Log.d("MGJ", "fileName:"  + fileName);
					mApkList.add(map);					
				}
			}
		}	
	}
	
	public class onBack implements OnClickListener {	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			GetApkActivity.this.finish();
		}
	}
}
