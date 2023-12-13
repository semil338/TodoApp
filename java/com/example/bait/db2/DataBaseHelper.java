package com.example.bait.db2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    final static public int DB_VERSION = 1;
    final static public String DB_NAME = "todoPrac.db";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    final static public String create_Query = "CREATE TABLE " + todoentry.TABLE_NAME + " ( "
            + todoentry._ID + " INTEGER PRIMARY KEY," + todoentry.title + " TEXT ) ";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
