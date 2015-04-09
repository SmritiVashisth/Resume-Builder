package com.example.resumebuilder;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

	ArrayList<String> list;
	private LayoutInflater inflater;
	Activity activity;
	TextView tvItemTitle, tvItemDuration, tvItemDescription;

	public CustomListAdapter(Activity activity) {
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.customlistview, null);

		tvItemTitle = (TextView) activity.findViewById(R.id.tvItemTitle);
		tvItemDuration = (TextView) activity.findViewById(R.id.tvItemDuration);
		tvItemDescription = (TextView) activity
				.findViewById(R.id.tvItemDescription);

		return convertView;
	}

}
