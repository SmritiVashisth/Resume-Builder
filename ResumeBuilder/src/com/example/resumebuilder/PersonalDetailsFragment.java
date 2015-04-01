package com.example.resumebuilder;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

@SuppressLint("NewApi")
public class PersonalDetailsFragment extends Fragment {

	String[] genderArr = { "Male", "Female", "Other" };
	String[] categoryArr = { "General", "OBC", "SC/ST" };

	Spinner genderSpinner, categorySpinner;

	public PersonalDetailsFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.personaldetails, container,
				false);

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

		return rootView;
	}
}
