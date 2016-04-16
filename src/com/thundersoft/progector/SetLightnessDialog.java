package com.thundersoft.progector;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SetLightnessDialog extends Dialog {
	
	
	private Context mContext = null;
	private View view = null;
	private RadioButton  highLight = null;
	private RadioButton  lowLight = null;
	private RadioButton  offLight = null;
	private Button mBtnCancle = null;
	private Button mBtnDone = null;
	private OnSelectLightnessListener onSelectLightnessListener;
	private TextView tv;
	
	public SetLightnessDialog(Context context) {
		this(context, 0);
	}
	public SetLightnessDialog(Context context, int theme) {
		super(context, R.style.customDialog);
		this.mContext = context;
		view = LayoutInflater.from(mContext).inflate(R.layout.dialog_set_light_progector, null);
		initView(view);
	}

	public SetLightnessDialog(Context context, TextView tv) {
		this(context, 0);
		this.tv = tv;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(view);
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		Resources resources = mContext.getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
		params.width = (int) (dm.widthPixels * 0.9);
		params.gravity = Gravity.CENTER;
		window.setAttributes(params);
	}
	
	private void initView(View view) {
		highLight=(RadioButton) view.findViewById(R.id.radio_high_light);
        lowLight=(RadioButton) view.findViewById(R.id.radio_low_light);
        offLight=(RadioButton) view.findViewById(R.id.radio_off_light);
      
		mBtnCancle = (Button) view.findViewById(R.id.btn_vp_cancle);
		mBtnDone = (Button) view.findViewById(R.id.btn_vp_ok);
		
		mBtnCancle.setOnClickListener(onClickListener);
		mBtnDone.setOnClickListener(onClickListener);
	}
	
	android.view.View.OnClickListener onClickListener = new android.view.View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btn_vp_cancle) {				
				SetLightnessDialog.this.dismiss();
			} else if (v.getId() == R.id.btn_vp_ok) {
				if (onSelectLightnessListener != null) {
					if (highLight.isChecked()) {
						onSelectLightnessListener.onLightnessValues(mContext.getResources().getString(R.string.high_light).toString());
						}
					if (lowLight.isChecked()) {
						onSelectLightnessListener.onLightnessValues(mContext.getResources().getString(R.string.low_light).toString());
						}
					if (offLight.isChecked()) {
						onSelectLightnessListener.onLightnessValues(mContext.getResources().getString(R.string.off_light).toString());
						}
				}

				SetLightnessDialog.this.dismiss();
			}
		}
	};
	
	public void setOnLightnessListener(OnSelectLightnessListener onSelectLightnessListener) {
		this.onSelectLightnessListener = onSelectLightnessListener;
	}
	
	public interface OnSelectLightnessListener {
		public void onLightnessValues(String string);
	}
}
