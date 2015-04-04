package com.example.resumebuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	// table_names
	private static final String TABLE_PERSONAL_DETAILS = "personal_details";
	
	// common key for all tables
	private static final String KEY_NAME = "name";

	// personal_details columns
	private static final String KEY_EMAIL = "email";
	private static final String KEY_CONTACT = "contact";
	private static final String KEY_EMPLOYMENT = "employment";
	private static final String KEY_FATHER = "father";
	private static final String KEY_GENDER = "gender";
	private static final String KEY_CATEGORY = "category";
	private static final String KEY_DOB = "dob";
	private static final String KEY_PERMADDR = "permaddr";
	private static final String KEY_CURRADDR = "curraddr";

	public Database(Context context, String name) {
		super(context, name, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE_PERSONAL_DETAILS = "CREATE TABLE "
				+ TABLE_PERSONAL_DETAILS + "(" + KEY_NAME + " PRIMARY KEY,"
				+ KEY_EMAIL + " TEXT," + KEY_CONTACT + " TEXT,"
				+ KEY_EMPLOYMENT + "TEXT," + KEY_FATHER + "TEXT," + KEY_GENDER
				+ "TEXT," + KEY_CATEGORY + "TEXT," + KEY_DOB + "TEXT,"
				+ KEY_PERMADDR + "TEXT," + KEY_CURRADDR + "TEXT);";
		db.execSQL(CREATE_TABLE_PERSONAL_DETAILS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAL_DETAILS);
		onCreate(db);

	}

	// PERSONAL DETAILS TABLE METHODS

	public void createPersonalDetails(PersonalDetails personaldetails) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, personaldetails.getName());
		values.put(KEY_EMAIL, personaldetails.getEmail());
		values.put(KEY_CONTACT, personaldetails.getContact());
		values.put(KEY_EMPLOYMENT, personaldetails.getEmployment());
		values.put(KEY_FATHER, personaldetails.getFather());
		values.put(KEY_GENDER, personaldetails.getGender());
		values.put(KEY_CATEGORY, personaldetails.getCategory());
		values.put(KEY_DOB, personaldetails.getDOB());
		values.put(KEY_PERMADDR, personaldetails.getPermaddr());
		values.put(KEY_CURRADDR, personaldetails.getCurraddr());
		db.insert(TABLE_PERSONAL_DETAILS, null, values);
		db.close();
	}

	public PersonalDetails getPersonalDetails(String person) {

		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + TABLE_PERSONAL_DETAILS
				+ " WHERE " + KEY_NAME + " = " + person;

		Cursor c = db.rawQuery(selectQuery, null);
		if (c != null)
			c.moveToFirst();

		PersonalDetails details = new PersonalDetails();
		details.setName(c.getString(c.getColumnIndex(KEY_NAME)));
		details.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
		details.setContact(c.getString(c.getColumnIndex(KEY_CONTACT)));
		details.setEmployment(c.getString(c.getColumnIndex(KEY_EMPLOYMENT)));
		details.setFather(c.getString(c.getColumnIndex(KEY_FATHER)));
		details.setGender(c.getString(c.getColumnIndex(KEY_GENDER)));
		details.setCategory(c.getString(c.getColumnIndex(KEY_CATEGORY)));
		details.setDOB(c.getString(c.getColumnIndex(KEY_DOB)));
		details.setPermaddr(c.getString(c.getColumnIndex(KEY_PERMADDR)));
		details.setCurraddr(c.getString(c.getColumnIndex(KEY_CURRADDR)));

		return details;
	}

	public void deletePersonalDetails(String person) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_PERSONAL_DETAILS, KEY_NAME + " = ?",
				new String[] { person });
		db.close();

	}

}
