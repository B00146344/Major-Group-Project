package com.example.test3.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.test3.data.User;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5; // update this whenever the columns change for the users table, this will call the onUpgrade method and recreate the database

    private static final String DATABASE_NAME = "Database.db";

    private static final String TABLE_USER = "user_accounts";

    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_USERNAME = "username";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String COLUMN_USER_DATE_OF_BIRTH = "date_of_birth";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_USERNAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT,"
            + COLUMN_USER_DATE_OF_BIRTH + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    // Friends table
    private static final String TABLE_FRIENDS = "friends";
    private static final String COLUMN_FRIEND_USER_ID = "user_id";
    private static final String COLUMN_FRIEND_ID = "friend_id";
    private static final String COLUMN_FRIEND_STATUS = "status";

    private static final String CREATE_FRIENDS_TABLE = "CREATE TABLE " + TABLE_FRIENDS + "("
            + COLUMN_FRIEND_USER_ID + " INTEGER,"
            + COLUMN_FRIEND_ID + " INTEGER,"
            + COLUMN_FRIEND_STATUS + " TEXT,"
            + "PRIMARY KEY (" + COLUMN_FRIEND_USER_ID + ", " + COLUMN_FRIEND_ID + "),"
            + "FOREIGN KEY (" + COLUMN_FRIEND_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "),"
            + "FOREIGN KEY (" + COLUMN_FRIEND_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ")"
            + ")";

    private final String DROP_FRIENDS_TABLE = "DROP TABLE IF EXISTS " + TABLE_FRIENDS;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("called creation");
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FRIENDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("called upgrade db");
//        db.execSQL(DROP_USER_TABLE);
//        db.execSQL(DROP_FRIENDS_TABLE);
        db.execSQL(CREATE_FRIENDS_TABLE);
//        onCreate(db);
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

    public boolean isValidEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USER_ID};
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        boolean exists = cursor.getCount() > 0;

        cursor.close();
        db.close();

        return exists;
    }

    public boolean isValidUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USER_ID};
        String selection = COLUMN_USER_USERNAME + " = ?";
        String[] selectionArgs = {username};

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
                COLUMN_USER_PASSWORD,
                COLUMN_USER_DATE_OF_BIRTH
        };

        String selection = COLUMN_USER_EMAIL + " = ? AND " + COLUMN_USER_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};

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
        String[] selectionArgs = {String.valueOf(user.getId())};

        db.update(TABLE_USER, values, selection, selectionArgs);
        db.close();
    }

    public void sendFriendRequest(int userId, int friendId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FRIEND_USER_ID, userId);
        values.put(COLUMN_FRIEND_ID, friendId);
        values.put(COLUMN_FRIEND_STATUS, "pending");

        db.insertWithOnConflict(TABLE_FRIENDS, null, values, SQLiteDatabase.CONFLICT_IGNORE);
        db.close();
    }
    public void acceptFriendRequest(int friendId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRIEND_STATUS, "accepted");
        String selection = COLUMN_FRIEND_ID + " = ?";
        String[] selectionArgs = {String.valueOf(friendId)};
        db.update(TABLE_FRIENDS, values, selection, selectionArgs);
        db.close();
    }

    public void acceptFriendRequest(int userId, int friendId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues valuesUpdate = new ContentValues();
//        valuesUpdate.put(COLUMN_FRIEND_STATUS, "accepted");
//        String selectionUpdate = COLUMN_FRIEND_USER_ID + " = ? AND " + COLUMN_FRIEND_ID + " = ?";
//        String[] selectionArgsUpdate = { String.valueOf(friendId), String.valueOf(userId) };
//        db.update(TABLE_FRIENDS, valuesUpdate, selectionUpdate, selectionArgsUpdate);
//
//        ContentValues valuesInsert = new ContentValues();
//        valuesInsert.put(COLUMN_FRIEND_USER_ID, userId);
//        valuesInsert.put(COLUMN_FRIEND_ID, friendId);
//        valuesInsert.put(COLUMN_FRIEND_STATUS, "accepted");
//        db.insert(TABLE_FRIENDS, null, valuesInsert);
//
//        db.close();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRIEND_STATUS, "accepted");

        String selection = COLUMN_FRIEND_USER_ID + " = ? AND " + COLUMN_FRIEND_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId), String.valueOf(friendId)};

        int count = db.update(TABLE_FRIENDS, values, selection, selectionArgs);

        if (count == 0) {
            Log.d("Database", "No records updated. The request might not exist or is already accepted.");
        }
        else {
            Log.d("Database", "Friend request accepted successfully.");
        }

        db.close();
    }

    public void rejectFriendRequest(int friendId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = COLUMN_FRIEND_ID + " = ?";
        String[] whereArgs = {String.valueOf(friendId)};
        db.delete(TABLE_FRIENDS, whereClause, whereArgs);
        db.close();
    }

    public void removeFriend(int userId, int friendId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = "(" + COLUMN_FRIEND_USER_ID + " = ? AND " + COLUMN_FRIEND_ID + " = ?) OR (" + COLUMN_FRIEND_USER_ID + " = ? AND " + COLUMN_FRIEND_ID + " = ?)";
        String[] whereArgs = { String.valueOf(userId), String.valueOf(friendId), String.valueOf(friendId), String.valueOf(userId) };

        db.delete(TABLE_FRIENDS, whereClause, whereArgs);
        db.close();
    }

    public List<User> getFriendRequests() {
        List<User> friendRequests = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_USER + " JOIN " + TABLE_FRIENDS +
                " ON " + TABLE_USER + "." + COLUMN_USER_ID + " = " + TABLE_FRIENDS + "." + COLUMN_FRIEND_USER_ID +
                " WHERE " + TABLE_FRIENDS + "." + COLUMN_FRIEND_STATUS + " = 'pending'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_USERNAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)),
                        null
                );
                friendRequests.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return friendRequests;
    }

    public List<User> getFriendRequestsByUser(int userId) {
        List<User> friendRequests = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Modify the query to select friend requests where the specified user is the recipient
        String query = "SELECT * FROM " + TABLE_USER + " JOIN " + TABLE_FRIENDS +
                " ON " + TABLE_USER + "." + COLUMN_USER_ID + " = " + TABLE_FRIENDS + "." + COLUMN_FRIEND_ID +
                " WHERE " + TABLE_FRIENDS + "." + COLUMN_FRIEND_USER_ID + " = ? AND " +
                TABLE_FRIENDS + "." + COLUMN_FRIEND_STATUS + " = 'pending'";

        Cursor cursor = db.rawQuery(query, new String[] {String.valueOf(userId)});

        if (cursor.moveToFirst()) {
            do {
                User user = new User(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_USERNAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)),
                        null
                );
                friendRequests.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return friendRequests;
    }

    public User getUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[]{COLUMN_USER_ID, COLUMN_USER_USERNAME, COLUMN_USER_EMAIL, COLUMN_USER_PASSWORD, COLUMN_USER_DATE_OF_BIRTH}, COLUMN_USER_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        cursor.close();
        return user;
    }

    public int getUserIdByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[]{COLUMN_USER_ID}, COLUMN_USER_USERNAME + " = ?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int userId = cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID));
            cursor.close();
            db.close();
            return userId;
        }

        cursor.close();
        db.close();
        return -1;  // Return -1 or throw an exception if the user is not found
    }

    public List<User> getFriends(int userId) {
        List<User> friendsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to find friends of the user
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_USER_ID + " IN ("
                + "SELECT " + COLUMN_FRIEND_ID + " FROM " + TABLE_FRIENDS + " WHERE " + COLUMN_FRIEND_USER_ID + " = " + userId + " AND " + COLUMN_FRIEND_STATUS + " = 'accepted'"
                + " UNION "
                + "SELECT " + COLUMN_FRIEND_USER_ID + " FROM " + TABLE_FRIENDS + " WHERE " + COLUMN_FRIEND_ID + " = " + userId + " AND " + COLUMN_FRIEND_STATUS + " = 'accepted')";

        Cursor cursor = db.rawQuery(query, null);

        // Iterate over the cursor to build the list of friend objects
        if (cursor.moveToFirst()) {
            do {
                User user = new User(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_USERNAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)),
                        null
                );
                friendsList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return friendsList;
    }
}
