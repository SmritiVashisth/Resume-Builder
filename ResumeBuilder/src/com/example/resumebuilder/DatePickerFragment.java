package com.example.resumebuilder;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

@SuppressLint("NewApi")
public class DatePickerFragment extends DialogFragment {
	/*
	 * @Override public Dialog onCreateDialog(Bundle savedInstanceState) { //
	 * Use the current date as the default date in the picker
	 * 
	 * int year, month, day;
	 * 
	 * Calendar c = Calendar.getInstance(); year = c.get(Calendar.YEAR); month =
	 * c.get(Calendar.MONTH); day = c.get(Calendar.DAY_OF_MONTH);
	 * 
	 * return new DatePickerDialog(getActivity(), this, year, month, day);
	 * 
	 * }
	 * 
	 * @Override public void onDateSet(DatePicker view, int year, int month, int
	 * day) {
	 * 
	 * Toast.makeText(getActivity(), "date set", Toast.LENGTH_LONG).show();
	 * Calendar c = Calendar.getInstance(); c.set(year, month, day);
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * Global.birthday = sdf.format(c.getTime()); Toast.makeText(getActivity(),
	 * Global.birthday, Toast.LENGTH_LONG) .show();
	 * 
	 * }
	 */

	OnDateSetListener ondateSet;

	public DatePickerFragment() {
	}

	public void setCallBack(OnDateSetListener ondate) {
		ondateSet = ondate;
	}

	private int year, month, day;

	@SuppressLint("NewApi")
	@Override
	public void setArguments(Bundle args) {
		super.setArguments(args);
		year = args.getInt("year");
		month = args.getInt("month");
		day = args.getInt("day");
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new DatePickerDialog(getActivity(), ondateSet, year, month, day);
	}
}
