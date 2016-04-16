package com.thundersoft.progector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class LanguageSettingsActivity extends Activity {
		
	    private LinearLayout btnBack = null;
	    private ListView languageLv;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.progector_language_settings);
			
			btnBack = (LinearLayout) findViewById(R.id.btn_back);
			btnBack.setOnClickListener(new onBack());
			
			final String[] languages = { "中文", "English" , "français" , "日本の" };
			languageLv = (ListView) findViewById(R.id.language_list);
			languageLv.setAdapter( new ArrayAdapter<String>( this,  
	                   android.R.layout.simple_list_item_single_choice , languages )); 
			
			
			languageLv.setOnItemClickListener(	new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Toast.makeText(LanguageSettingsActivity.this, languages[position].toString(),1).show();
				}
			});
		}
		
		
		public class onBack implements OnClickListener {
			public void onClick(View v) {
				LanguageSettingsActivity.this.finish();
			}
		}

}
