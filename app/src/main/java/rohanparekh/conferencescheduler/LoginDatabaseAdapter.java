package rohanparekh.conferencescheduler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rohan on 17-08-2016.
 */
public class LoginDatabaseAdapter {


        public static final int NAME_COLUMN = 1;
        static final String DATABASE_NAME = "login.db";
        static final int DATABASE_VERSION = 1;
        static final String DATABASE_CREATE = "create table " + "LOGIN" + "( "
                + "ID" + " integer autoincrement primary key,"
                + "USERNAME  text  ,PASSWORD text, ROLE text); ";
        private final Context context;
        public SQLiteDatabase db;
        private DataBaseHelper dbHelper;

        public LoginDatabaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    public LoginDatabaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String userName, String password, String radioValue) {
        ContentValues newValues = new ContentValues();
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);
        newValues.put("ROLE",radioValue);
        db.insert("LOGIN", null, newValues);

    }

    public int deleteEntry(String UserName) {

        String where = "USERNAME=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where,
                new String[] { UserName });
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("LOGIN", null, " USERNAME=?",
                new String[] { userName }, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String userName, String password, String role) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);
        updatedValues.put("ROLE", role);

        String where = "USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[] { userName });
    }
}

