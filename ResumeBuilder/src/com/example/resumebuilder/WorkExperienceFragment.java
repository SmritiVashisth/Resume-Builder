package com.example.resumebuilder;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class WorkExperienceFragment extends Fragment implements OnClickListener {

	Button btnAddWorkExp, btnSaveWorkExp;
	TextView tvWorkExp;
	EditText etPosition, etPlace, etFromWE, etToWE, etDescriptionWE;
	ListView workExpList;

	public WorkExperienceFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.workexperience, container,
				false);
		tvWorkExp = (TextView) rootView.findViewById(R.id.tvWorkExp);
		etDescriptionWE = (EditText) rootView
				.findViewById(R.id.etDescriptionWE);
		etFromWE = (EditText) rootView.findViewById(R.id.etFromWE);
		etToWE = (EditText) rootView.findViewById(R.id.etToWE);
		etPosition = (EditText) rootView.findViewById(R.id.etPosition);
		etPlace = (EditText) rootView.findViewById(R.id.etPlace);
		workExpList = (ListView) rootView.findViewById(R.id.lvWorkExp);
		btnAddWorkExp = (Button) rootView.findViewById(R.id.btnAddWorkExp);
		btnSaveWorkExp = (Button) rootView.findViewById(R.id.btnSaveWorkExp);

		tvWorkExp.setText("List your previous work experience");
		btnAddWorkExp.setOnClickListener(this);
		btnSaveWorkExp.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnAddWorkExp:
			String strPosition = etPosition.getText().toString();
			String strPlace = etPlace.getText().toString();
			int intFrom = Integer.parseInt(etFromWE.getText().toString());
			int intTo = Integer.parseInt(etToWE.getText().toString());
			String strDescription = etDescriptionWE.getText().toString();

			CustomListAdapter adapter = new CustomListAdapter(getActivity(),
					strPosition, strDescription, intFrom, intTo);
			workExpList.setAdapter(adapter);

			tvWorkExp.setText("Extra-Curriculur Activities");
			Database db = new Database(getActivity());
			db.addWorkExperience(Global.personName, etPosition.getText()
					.toString(), etPlace.getText().toString(), Integer
					.parseInt(etFromWE.getText().toString()), Integer
					.parseInt(etToWE.getText().toString()), etDescriptionWE
					.getText().toString());
			etPosition.setText(null);
			etPlace.setText(null);
			etFromWE.setText(null);
			etToWE.setText(null);
			etDescriptionWE.setText(null);
			adapter.notifyDataSetChanged();
			break;

		case R.id.btnSaveWorkExp:
			btnAddWorkExp.setVisibility(View.INVISIBLE);
			break;
		}
	}

}
