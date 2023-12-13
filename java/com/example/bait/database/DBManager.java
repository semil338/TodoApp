package com.example.bait.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    DatabaseHelper dbHelper;
    Context context;

    SQLiteDatabase database;

    public DBManager(Context context) {
        this.context = context;
    }

    public void openDB()  throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public long insert(Todo todo){
        ContentValues cv = new ContentValues();
        cv.put(TodoEntry.title,todo.title);
        return  database.insert(TodoEntry.TABLE_NAME,null,cv);
    }


    public ArrayList<Todo> fetchAll() {
        ArrayList<Todo> todos = new ArrayList<>();
        Cursor c = database.rawQuery("SELECT * FROM " + TodoEntry.TABLE_NAME, null);
        while (c.moveToNext()) {
            Todo s = new Todo();
            s.setId(c.getLong(0));
            s.setTitle(c.getString(1));
            todos.add(s);
        }
        return todos;
    }

}

