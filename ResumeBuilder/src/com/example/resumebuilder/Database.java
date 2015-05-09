package com.example.resumebuilder;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "resume";

	// table_names
	private static final String TABLE_PERSONAL_DETAILS = "personal_details";
	private static final String TABLE_INTERESTS = "areas_of_interest";
	private static final String TABLE_EXTRA_CURR = "extra_curriculars";
	private static final String TABLE_WORK_EXP = "work_experience";

	// common key for all tables
	private static final String KEY_NAME = "_name";
	private static final String KEY_ID = "_id";

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

	// interests columns
	private static final String KEY_INTERESTS = "interests";

	// extra curricular columns
	private static final String KEY_TITLE = "title";
	private static final String KEY_FROM = "fromYear";
	private static final String KEY_TO = "toYear";
	private static final String KEY_DESCRIPTION = "description";

	// work experience columns
	private static final String KEY_POSITION = "position";
	private static final String KEY_PLACE = "place";

	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE_PERSONAL_DETAILS = "CREATE TABLE "
				+ TABLE_PERSONAL_DETAILS + " ( " + KEY_NAME + " PRIMARY KEY,"
				+ KEY_EMAIL + " TEXT," + KEY_CONTACT + " TEXT,"
				+ KEY_EMPLOYMENT + " TEXT," + KEY_FATHER + " TEXT,"
				+ KEY_GENDER + " TEXT," + KEY_CATEGORY + " TEXT," + KEY_DOB
				+ " TEXT," + KEY_PERMADDR + " TEXT," + KEY_CURRADDR + " TEXT);";
		db.execSQL(CREATE_TABLE_PERSONAL_DETAILS);

		String CREATE_TABLE_INTERESTS = "CREATE TABLE " + TABLE_INTERESTS
				+ " ( " + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
				+ " TEXT," + KEY_INTERESTS + " TEXT);";
		db.execSQL(CREATE_TABLE_INTERESTS);

		String CREATE_TABLE_EXTRA_CURR = "CREATE TABLE " + TABLE_EXTRA_CURR
				+ " ( " + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME
				+ " TEXT, " + KEY_TITLE + " TEXT, " + KEY_FROM + " INTEGER, "
				+ KEY_TO + " INTEGER, " + KEY_DESCRIPTION + " TEXT);";
		db.execSQL(CREATE_TABLE_EXTRA_CURR);

		String CREATE_TABLE_WORK_EXP = "CREATE TABLE " + TABLE_WORK_EXP + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, "
				+ KEY_POSITION + " TEXT, " + KEY_PLACE + " TEXT, " + KEY_FROM
				+ " INTEGER, " + KEY_TO + " INTEGER, " + KEY_DESCRIPTION
				+ " TEXT);";
		db.execSQL(CREATE_TABLE_WORK_EXP);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONAL_DETAILS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_INTERESTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXTRA_CURR);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORK_EXP);
		onCreate(db);

	}

	// PERSONAL DETAILS TABLE METHODS

	public void addPersonalDetails(PersonalDetails personaldetails) {
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
				+ " WHERE " + KEY_NAME + " = " + "'" + person + "'";

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
		c.close();

		return details;
	}

	public void deletePersonalDetails(String person) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_PERSONAL_DETAILS, KEY_NAME + " = ?",
				new String[] { person });
		db.close();

	}

	// INTERESTS TABLE METHODS

	public void addInterests(String person, ArrayList<String> interests) {
		SQLiteDatabase db = this.getWritableDatabase();
		int size = interests.size();
		for (int i = 0; i < size; i++) {
			ContentValues values = new ContentValues();
			values.put(KEY_NAME, person);
			values.put(KEY_INTERESTS, interests.get(i));
			db.insert(TABLE_INTERESTS, null, values);
		}
		db.close();
	}

	public ArrayList<String> getInterests(String person) {

		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + TABLE_INTERESTS + " WHERE "
				+ KEY_NAME + " = " + "'" + person + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		ArrayList<String> interests = new ArrayList<String>();

		if (c.moveToFirst()) {
			do {
				String str = c.getString(c.getColumnIndex(KEY_INTERESTS));
				interests.add(str);
			} while (c.moveToNext());
		}

		return interests;
	}

	public void deleteInterests(String person) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_INTERESTS, KEY_NAME + " = ?", new String[] { person });
		db.close();
	}

	// EXTRA CURRICULUR TABLE METHODS

	public void addExtraCurricular(String person, String title, int from,
			int to, String description) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, person);
		values.put(KEY_TITLE, title);
		values.put(KEY_FROM, from);
		values.put(KEY_TO, to);
		values.put(KEY_DESCRIPTION, description);
		db.insert(TABLE_EXTRA_CURR, null, values);
		db.close();
	}

	public ArrayList<ExtraCurriculars> getExtraCurricular(String person) {

		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + TABLE_EXTRA_CURR + " WHERE "
				+ KEY_NAME + " = " + "'" + person + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		ArrayList<ExtraCurriculars> extracurr = new ArrayList<ExtraCurriculars>();

		if (c.moveToFirst()) {
			do {
				ExtraCurriculars curr = new ExtraCurriculars();
				curr.setTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
				curr.setFrom(Integer.parseInt(c.getString(c
						.getColumnIndex(KEY_FROM))));
				curr.setTo(Integer.parseInt(c.getString(c
						.getColumnIndex(KEY_TO))));
				curr.setDescription(c.getString(c
						.getColumnIndex(KEY_DESCRIPTION)));
				extracurr.add(curr);
			} while (c.moveToNext());
		}
		c.close();
		return extracurr;

	}

	public void deleteExtraCurriculurs(String person) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_EXTRA_CURR, KEY_NAME + " = ?", new String[] { person });
		db.close();
	}

	// WORK EXPERIENCE TABLE METHODS

	public void addWorkExperience(String person, String position, String place,
			int from, int to, String description) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, person);
		values.put(KEY_POSITION, position);
		values.put(KEY_PLACE, place);
		values.put(KEY_FROM, from);
		values.put(KEY_TO, to);
		values.put(KEY_DESCRIPTION, description);
		db.insert(TABLE_WORK_EXP, null, values);
		db.close();
	}

	public ArrayList<WorkExperience> getWorkExperience(String person) {

		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT  * FROM " + TABLE_WORK_EXP + " WHERE "
				+ KEY_NAME + " = " + "'" + person + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		ArrayList<WorkExperience> workexp = new ArrayList<WorkExperience>();

		if (c.moveToFirst()) {
			do {
				WorkExperience exp = new WorkExperience();
				exp.setPosition(c.getString(c.getColumnIndex(KEY_POSITION)));
				exp.setPlace(c.getString(c.getColumnIndex(KEY_PLACE)));
				exp.setFrom(Integer.parseInt(c.getString(c
						.getColumnIndex(KEY_FROM))));
				exp.setTo(Integer.parseInt(c.getString(c.getColumnIndex(KEY_TO))));
				exp.setDescription(c.getString(c
						.getColumnIndex(KEY_DESCRIPTION)));
				workexp.add(exp);
			} while (c.moveToNext());
		}
		c.close();
		return workexp;

	}

	public void deleteWorkExperience(String person) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_WORK_EXP, KEY_NAME + " = ?", new String[] { person });
		db.close();
	}
}
