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
public class ExtraCurrFragment extends Fragment implements OnClickListener {

	Button btnAddExtraCurr, btnSaveExtraCurr;
	TextView tvExtraCurr, tvDuration;
	EditText etTitle, etFrom, etTo, etDescription;
	ListView extraCurrList;

	public ExtraCurrFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.extracurr, container, false);

		tvExtraCurr = (TextView) rootView.findViewById(R.id.tvExtraCurr);
		tvDuration = (TextView) rootView.findViewById(R.id.tvDuration);
		etDescription = (EditText) rootView.findViewById(R.id.etDescription);
		etFrom = (EditText) rootView.findViewById(R.id.etFrom);
		etTo = (EditText) rootView.findViewById(R.id.etTo);
		etTitle = (EditText) rootView.findViewById(R.id.etTitle);
		extraCurrList = (ListView) rootView.findViewById(R.id.lvExtraCurr);
		btnAddExtraCurr = (Button) rootView.findViewById(R.id.btnAddExtraCurr);
		btnSaveExtraCurr = (Button) rootView
				.findViewById(R.id.btnSaveExtraCurr);

		tvExtraCurr.setText("List your extra-curriculur activities");
		btnAddExtraCurr.setOnClickListener(this);
		btnSaveExtraCurr.setOnClickListener(this);

		return rootView;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnAddExtraCurr:
			String strTitle = etTitle.getText().toString();
			int intFrom = Integer.parseInt(etFrom.getText().toString());
			int intTo = Integer.parseInt(etTo.getText().toString());
			String strDescription = etDescription.getText().toString();

			CustomListAdapter adapter = new CustomListAdapter(getActivity(),
					strTitle, strDescription, intFrom, intTo);
			extraCurrList.setAdapter(adapter);

			tvExtraCurr.setText("Extra-Curriculur Activities");
			Database db = new Database(getActivity());
			db.addExtraCurricular(Global.personName, etTitle.getText()
					.toString(), Integer.parseInt(etFrom.getText().toString()),
					Integer.parseInt(etTo.getText().toString()), etDescription
							.getText().toString());
			etTitle.setText(null);
			etFrom.setText(null);
			etTo.setText(null);
			etDescription.setText(null);
			adapter.notifyDataSetChanged();
			break;
			
		case R.id.btnSaveExtraCurr:
			btnAddExtraCurr.setVisibility(View.INVISIBLE);
			break;
		}
	}
}
