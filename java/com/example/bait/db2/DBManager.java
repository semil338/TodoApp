package com.example.bait.db2;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.bait.database.DatabaseHelper;

public class DBManager{
    DataBaseHelper dbh;

    Context context;

    SQLiteDatabase db1;

    public DBManager(Context context)
    {
        this.context = context;
    }

    public void opendb() throws SQLException
    {
        dbh = new DataBaseHelper(context);
        db1 = dbh.getWritableDatabase();
    }

    public void closedb()
    {
        db1.close();
    }

    public long insert(todo t)
    {
        ContentValues ct = new ContentValues();

        ct.put(todoentry.title,t.title);
        return db1.insert(todoentry.TABLE_NAME , null, ct);
    }
}
