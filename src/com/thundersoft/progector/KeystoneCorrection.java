package com.thundersoft.progector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class KeystoneCorrection extends Activity {
		
		private ImageButton increaseNum;
		private ImageButton reduceNum;
		private TextView correctionNum;
		private int keyValue = 0;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.progector_keystone_corerrection);
			
			 correctionNum = (TextView) findViewById(R.id.correction_num);
			 increaseNum = (ImageButton) findViewById(R.id.increase_num);
			 increaseNum.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(keyValue < 7){
						keyValue++;
					}else{
						keyValue = 7;
					}
					correctionNum.setText( String.valueOf(keyValue));
				}
			});
			 reduceNum = (ImageButton) findViewById(R.id.reduce_num);
			 reduceNum.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(keyValue >  (-7)){
							keyValue--;
						}else{
							keyValue = -7;
						}
						correctionNum.setText( String.valueOf(keyValue));
					}
				});
			
		}
		

}
