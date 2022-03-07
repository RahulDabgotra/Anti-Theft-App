package com.example.anti_theft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegisterData {
    private static final String DATABASE_NAME = "AntiTheftData";
    private static final String DATABASE_TABLE = "registerData";
    private static final String DATABASE_TABLE1 = "registerNumber";
    private static final int DATABASE_VERSION = 1;
    public static final String KEY_ID = "user_id";
    public static final String KEY_NID = "number_id";
    public static final String KEY_NUMBER = "number";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_USERNAME = "username";
    private final Context ourcontext;
    private SQLiteDatabase ourdatabase;
    private Dbhelper ourhelper;

    public RegisterData(Context con) {
        this.ourcontext = con;
    }

    /* access modifiers changed from: private */
    public static class Dbhelper extends SQLiteOpenHelper {
        public Dbhelper(Context context) {
            super(context, RegisterData.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE registerData(user_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL, password TEXT NOT NULL);");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS registerData");
            db.execSQL("DROP TABLE IF EXISTS registerNumber");
            onCreate(db);
        }
    }

    public RegisterData open() {
        this.ourhelper = new Dbhelper(this.ourcontext);
        this.ourdatabase = this.ourhelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.ourdatabase.close();
    }

    public long insertdata(String user, String password) {
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user);
        values.put(KEY_PASSWORD, password);
        return this.ourdatabase.insert(DATABASE_TABLE, null, values);
    }

    public boolean verifyUser(String user, String password) {
        String[] strArr = {KEY_USERNAME, KEY_PASSWORD};
        Cursor cp = this.ourdatabase.query(DATABASE_TABLE, null, "username= ? AND password= ? ", new String[]{user, password}, null, null, null);
        System.out.println(cp);
        if (cp.moveToFirst()) {
            return true;
        }
        return false;
    }

    public boolean updatePassword(String opwd, String npwd) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_PASSWORD, npwd);
        if (this.ourdatabase.update(DATABASE_TABLE, cv, "password =?", new String[]{opwd}) <= 0) {
            return false;
        }
        System.out.println(true);
        return true;
    }

    public long insertData(String number) {
        ContentValues values = new ContentValues();
        values.put(KEY_NUMBER, number);
        return this.ourdatabase.insert(DATABASE_TABLE1, null, values);
    }

    public String fetchNumber() {
        Cursor c = this.ourdatabase.rawQuery("Select * from registerNumber", null);
        c.moveToFirst();
        if (!c.isAfterLast()) {
            return c.getString(1);
        }
        return "";
    }
}
