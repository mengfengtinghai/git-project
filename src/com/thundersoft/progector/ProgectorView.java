package com.thundersoft.progector;
import android.R.id;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class ProgectorView extends Activity implements OnClickListener{
	
	private LinearLayout btnBack = null;
	private Button BtnFolder;
	private Button BtnMore;
	private Button BtnMenu;
	private Button BtnHome;
	private Button BtnRetrun;
	private Button BtnMouse;
	private Button BtnCursor;
	private Button Btn1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.progector_main_view);
		
		btnBack = (LinearLayout) findViewById(R.id.btn_back);
		btnBack.setOnClickListener(new onBack());
		BtnFolder = (Button) findViewById(R.id.btn_folder);
		BtnFolder.setOnClickListener(this);
		BtnMore = (Button) findViewById(R.id.btn_more);
		BtnMore.setOnClickListener(this);
		BtnHome = (Button) findViewById(R.id.btn_home);
		BtnMore.setOnClickListener(this);
		BtnMouse = (Button) findViewById(R.id.btn_mouse);
		BtnMouse.setOnClickListener(this);
		BtnCursor = (Button) findViewById(R.id.btn_cursor);
		BtnCursor.setOnClickListener(this);
		Btn1 = (Button) findViewById(R.id.button1);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_folder:
			Intent t =new Intent(this,MainActivity.class);
			startActivity(t);
			break;
		case R.id.btn_more:
			BtnMore.setBackgroundResource(R.drawable.btn_title_more_gray);
			Intent intent = new Intent(ProgectorView.this, ProgectorMoreActivity.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.btn_home:
			Intent t1 =new Intent(this,MainActivity.class);
			startActivity(t1);			
			break;
		case R.id.btn_mouse:
			BtnCursor.setVisibility(View.VISIBLE);
			BtnMouse.setVisibility(View.INVISIBLE);
			Btn1.setVisibility(View.INVISIBLE);
			break;
		case R.id.btn_cursor:
			BtnCursor.setVisibility(View.INVISIBLE);
			BtnMouse.setVisibility(View.VISIBLE);
			Btn1.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		BtnMore.setBackgroundResource(R.drawable.btn_title_more);
		
		switch (resultCode) {
		case 1:
			Intent t2 =new Intent(this,ProgectVoice.class);
			startActivity(t2);
			break;

		default:
			break;
		}
	}

	public class onBack implements OnClickListener {
		public void onClick(View v) {
			ProgectorView.this.finish();
		}
	}
}
