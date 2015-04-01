package com.example.resumebuilder;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint("NewApi")
public class PersonalDetailsFragment extends Fragment implements
		OnClickListener {

	String[] genderArr = { "Male", "Female", "Other" };
	String[] categoryArr = { "General", "OBC", "SC/ST" };
	int year, month, day;
	String date;

	Spinner genderSpinner, categorySpinner;
	EditText etName, etEmail, etContact, etEmployment, etFather, etPermanent,
			etCurrent;
	ImageButton imgBtnDate;
	Button btnPersonalDetails;

	public PersonalDetailsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.personaldetails, container,
				false);

		etName = (EditText) rootView.findViewById(R.id.etName);
		etEmail = (EditText) rootView.findViewById(R.id.etEmail);
		etContact = (EditText) rootView.findViewById(R.id.etContact);
		etEmployment = (EditText) rootView.findViewById(R.id.etEmployment);
		etFather = (EditText) rootView.findViewById(R.id.etFather);
		etPermanent = (EditText) rootView.findViewById(R.id.etPermanent);
		etCurrent = (EditText) rootView.findViewById(R.id.etCurrent);
		imgBtnDate = (ImageButton) rootView.findViewById(R.id.imgBtnDate);
		btnPersonalDetails = (Button) rootView
				.findViewById(R.id.btnPersonalDetails);

		
		genderSpinner = (Spinner) rootView.findViewById(R.id.gender_spinner);
		ArrayAdapter<String> adapter_gender = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, genderArr);
		adapter_gender
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		genderSpinner.setAdapter(adapter_gender);

		
		categorySpinner = (Spinner) rootView
				.findViewById(R.id.category_spinner);
		ArrayAdapter<String> adapter_category = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item,
				categoryArr);
		adapter_category
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter_category);

		
		imgBtnDate.setOnClickListener(this);
		btnPersonalDetails.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.imgBtnDate:
			Toast.makeText(getActivity(), "Image button clicked",
					Toast.LENGTH_LONG).show();
			DialogFragment picker = new DatePickerFragment();
			picker.show(getFragmentManager(), "datePicker");
			break;
		case R.id.btnPersonalDetails:
			break;
		}

	}

}
