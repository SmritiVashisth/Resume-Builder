package com.example.resumebuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressLint("NewApi")
public class PersonalDetailsFragment extends Fragment implements
		OnClickListener, OnItemSelectedListener, OnDateSetListener {

	String[] genderArr = { "Male", "Female", "Other" };
	String[] categoryArr = { "General", "OBC", "SC/ST" };
	int year, month, day;
	String date, selGender, selCategory, formattedDate;

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
		genderSpinner.setOnItemSelectedListener(this);

		categorySpinner = (Spinner) rootView
				.findViewById(R.id.category_spinner);
		ArrayAdapter<String> adapter_category = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item,
				categoryArr);
		adapter_category
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter_category);
		categorySpinner.setOnItemSelectedListener(this);

		imgBtnDate.setOnClickListener(this);
		btnPersonalDetails.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {

		Calendar c = Calendar.getInstance();
		c.set(year, month, day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		formattedDate = sdf.format(c.getTime());
		Toast.makeText(getActivity(), formattedDate, Toast.LENGTH_LONG).show();

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
			Database db = new Database(getActivity());
			PersonalDetails details = new PersonalDetails();
			details.setName(etName.getText().toString());
			details.setEmail(etEmail.getText().toString());
			details.setContact(etContact.getText().toString());
			details.setEmployment(etEmployment.getText().toString());
			details.setFather(etFather.getText().toString());
			details.setGender(selGender);
			details.setCategory(selCategory);
			details.setDOB(formattedDate);
			details.setPermaddr(etPermanent.getText().toString());
			details.setCurraddr(etCurrent.getText().toString());
			db.addPersonalDetails(details);
			db.close();
			break;
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		switch (parent.getId()) {
		case R.id.gender_spinner:
			genderSpinner.setSelection(position);
			selGender = (String) genderSpinner.getSelectedItem();
			Log.i("gender", selGender);
			break;
		case R.id.category_spinner:
			Log.i("tag", "Ïtem Selected");
			categorySpinner.setSelection(position);
			selCategory = (String) categorySpinner.getSelectedItem();
			Log.i("category", selCategory);
			break;
		default:
			Toast.makeText(
					getActivity(),
					"You have not selected anything, please select one option from the spinner",
					Toast.LENGTH_LONG).show();
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		Toast.makeText(
				getActivity(),
				"You have not selected anything, please select one option from the spinner",
				Toast.LENGTH_LONG).show();
	}

}
