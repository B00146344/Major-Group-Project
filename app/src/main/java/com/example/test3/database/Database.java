package com.example.test3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.test3.data.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 3; // update this whenever the columns change for the users table, this will call the onUpgrade method and recreate the database

    // Database Name
    private static final String DATABASE_NAME = "Database.db";

    // User table name
    private static final String TABLE_USER = "user_accounts";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_USERNAME = "username";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String COLUMN_USER_DATE_OF_BIRTH = "date_of_birth";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_USERNAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," // Add this line for the email column
            + COLUMN_USER_PASSWORD + " TEXT,"
            + COLUMN_USER_DATE_OF_BIRTH + " TEXT" + ")"; // Ensure the data type is TEXT

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("called creation");
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("called upgrade db");
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addUser(User user) {
        System.out.println("calling adduser");
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, user.getUsername());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
//        values.put(COLUMN_USER_DATE_OF_BIRTH, user.getDateOfBirth().toString());

        long a = db.insert(TABLE_USER, null, values);
        db.close();
        System.out.println("created: " + a);
    }

    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_USERNAME,
                COLUMN_USER_EMAIL,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_DATE_OF_BIRTH
        };

        // sorting orders
        String sortOrder = COLUMN_USER_USERNAME + " ASC";
        List<User> userList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,
                null,
                null,
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order

        if (cursor.moveToFirst()) {
            do {
                User user = new User(
                        Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_USERNAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)),
                        null);


//                user.setDateOfBirth(Date.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_USER_DATE_OF_BIRTH)))); // Changed
                Log.d("Database", "User: " + user.getId() + ", " + user.getUsername() + ", " + user.getEmail() + " - " + user.getPassword());
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return userList;
    }

    public boolean isUserExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = { COLUMN_USER_ID };
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return exists;
    }

    public User validateUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_USERNAME,
                COLUMN_USER_EMAIL,
                COLUMN_USER_PASSWORD, // Include this if you need to fetch password
                COLUMN_USER_DATE_OF_BIRTH
        };

        String selection = COLUMN_USER_EMAIL + " = ? AND " + COLUMN_USER_PASSWORD + " = ?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            User user = new User(cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_USER_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)),
                    null); // Assuming Date of Birth is not required here
            Log.d("Database", "User: " + user.getId() + ", " + user.getUsername() + ", " + user.getPassword() + ", " + user.getEmail());

            cursor.close();
            return user;
        }
        cursor.close();
        return null;
    }

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_USERNAME, user.getUsername());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        String selection = COLUMN_USER_ID + " = ?";
        String[] selectionArgs = { String.valueOf(user.getId()) };

        db.update(TABLE_USER, values, selection, selectionArgs);
        db.close();
    }
}
