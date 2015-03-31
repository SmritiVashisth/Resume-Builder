package com.example.resumebuilder;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("NewApi")
public class CreateResume extends ActionBarActivity implements
		OnItemClickListener {

	ListView mDrawerList;
	DrawerLayout mDrawerLayout;
	String[] list = { "Personal Details", "Educational Qualifications",
			"Skills and Achievements", "Projects",
			"Extra Curriculur Activities", "Work Experience", "Interests" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createresume);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		mDrawerList.setAdapter(adapter);
		mDrawerList.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		selectItem(position);

	}

	@SuppressLint("NewApi")
	private void selectItem(int position) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new PersonalDetailsFragment();
			break;
		case 1:
			fragment = new EducationalFragment();
			break;
		case 2:
			fragment = new SkillsFragment();
			break;
		case 3:
			fragment = new ProjectsFragment();
			break;
		case 4:
			fragment = new ExtraCurrFragment();
			break;
		case 5:
			fragment = new WorkExperienceFragment();
			break;
		case 6:
			fragment = new InterestFragment();
			break;

		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(list[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("Create Resume", "Error in creating fragment");
		}
	}

}
