package com.example.resumebuilder;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

@SuppressLint("NewApi")
public class InterestFragment extends Fragment implements OnClickListener {

	ListView lvInterest;
	EditText etInterest;
	Button btnAddInterest, btnSaveInterest;
	ArrayList<String> interests = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	public InterestFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.interest, container, false);

		lvInterest = (ListView) rootView.findViewById(R.id.lvInterests);
		etInterest = (EditText) rootView.findViewById(R.id.etInterest);
		btnAddInterest = (Button) rootView.findViewById(R.id.btnAddInterest);
		btnSaveInterest = (Button) rootView.findViewById(R.id.btnSaveInterest);

		etInterest.setText(null);
		btnAddInterest.setOnClickListener(this);
		btnSaveInterest.setOnClickListener(this);

		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, interests);
		lvInterest.setAdapter(adapter);

		return rootView;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnAddInterest:
			String str = etInterest.getText().toString();
			if (str.length() > 0) {
				interests.add(str);
				etInterest.setText(null);
				adapter.notifyDataSetChanged();
			}
			break;
		case R.id.btnSaveInterest:
			adapter.notifyDataSetChanged();
			btnAddInterest.setVisibility(View.INVISIBLE);
			etInterest.setVisibility(View.INVISIBLE);
			
			Database db = new Database(getActivity());
			db.addInterests(Global.personName, interests);
			break;
		}
	}

}
