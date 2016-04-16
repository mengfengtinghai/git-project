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
import android.widget.EditText;
import android.widget.NumberPicker;

public class TimePickerDialog extends Dialog {
	
	private Context mContext = null;
	private View view = null;
	private NumberPicker hourSetting = null;
	private NumberPicker secondSetting = null;
	private Button mBtnCancle = null;
	private Button mBtnDone = null;
	private OnValuesPickerListener onValuesPickerListener = null;
	
	public TimePickerDialog(Context context) {
		this(context, 0);
	}

	public TimePickerDialog(Context context, int style) {
		super(context, R.style.customDialog);
		this.mContext = context;
		view = LayoutInflater.from(mContext).inflate(R.layout.dialog_time_picker, null);
		initView(view);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(view);
		Window window = getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		Resources resources = mContext.getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
		// params.height = (int) (dm.heightPixels * 0.5);
		params.width = (int) (dm.widthPixels * 0.9);
		params.gravity = Gravity.CENTER;
		window.setAttributes(params);
	}

	private final String[] hourValues = { "0", "1", "2", "3", "4", "5","6","7","8","9",
																			"10","11","12","13","14","15","16","17","18","19",
																			"20","21","22","23"};
	private final String[] secondValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ,
																		"10","11","12","13","14","15","16","17","18","19",
			 															"20","21","22","23","24","25","26","27","28","29",
			 															"30","31","32","33","34","35","36","37","38","39",
			 															"40","41","42","43","44","45","46","47","48","49",
			 															"50","51","52","53","54","55","56","57","58","59"};
	
	private void initView(View view) {
		hourSetting = (NumberPicker) view.findViewById(R.id.hour_setting);
		secondSetting = (NumberPicker) view.findViewById(R.id.second_setting);
		mBtnCancle = (Button) view.findViewById(R.id.btn_vp_cancle);
		mBtnDone = (Button) view.findViewById(R.id.btn_vp_ok);
		hourSetting.setMaxValue(23);
		hourSetting.setMinValue(0);
		hourSetting.setDisplayedValues(hourValues);
		secondSetting.setMaxValue(59);
		secondSetting.setMinValue(0);
		secondSetting.setDisplayedValues(secondValues);
		for (int i = 0; i < hourSetting.getChildCount(); i++) {
			View v = hourSetting.getChildAt(i);
			if (v instanceof EditText) {
				((EditText) v).setFocusable(false);
			}
		}
		for (int i = 0; i < secondSetting.getChildCount(); i++) {
			View v = secondSetting.getChildAt(i);
			if (v instanceof EditText) {
				((EditText) v).setFocusable(false);
			}

		}
		mBtnCancle.setOnClickListener(onClickListener);
		mBtnDone.setOnClickListener(onClickListener);
	}
	
	android.view.View.OnClickListener onClickListener = new android.view.View.OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v.getId() == R.id.btn_vp_cancle) {
//				if (tb != null) {
//					tb.setChecked(false);
//				}
				TimePickerDialog.this.dismiss();
			} else if (v.getId() == R.id.btn_vp_ok) {
				if (onValuesPickerListener != null) {
					onValuesPickerListener.onPickerValues(Integer.parseInt(hourValues[hourSetting.getValue()]), Integer.parseInt(secondValues[secondSetting.getValue()]));
				}
				TimePickerDialog.this.dismiss();
			}
		}
	};
	
	/**
	 * 设置picker返回值监听
	 * 
	 * @param _onValuesPickerListener
	 */
	public void setOnValuesPickerListener(OnValuesPickerListener onValuesPickerListener) {
		this.onValuesPickerListener = onValuesPickerListener;
	}

	public interface OnValuesPickerListener {
		public void onPickerValues(int hourValues, int secondValues);
	}
	
}
