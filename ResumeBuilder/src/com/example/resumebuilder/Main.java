package com.example.resumebuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends ActionBarActivity implements OnClickListener {
	
	Button btnCreate, btnView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnCreate = (Button) findViewById(R.id.btnCreate);
		btnView = (Button) findViewById(R.id.btnView);
		btnCreate.setOnClickListener(this);
		btnView.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()){
		case R.id.btnCreate:
			Intent intent1 = new Intent(Main.this,CreateResume.class);
			startActivity(intent1);
			break;
		case R.id.btnView:
			Intent intent2 = new Intent(Main.this,ViewResume.class);
			startActivity(intent2);
			break;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
