package com.thundersoft.progector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button Btn1;
	private Button btn2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Btn1 = (Button) findViewById(R.id.button1);
		Btn1.setOnClickListener(this);
		btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch  (v.getId()) {
		case R.id.button1:
			Intent t =new Intent(this,ProgectorView.class);
			startActivity(t);
			break;
		case R.id.button2:
			
			break;
		default:
			break;
		}
	}

	

}
