package com.example.bait;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.bait.database.DBManager;
import com.example.bait.database.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView view;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,FormActivity.class);
            startActivity(intent);
        });

        DBManager dbManager = new DBManager(this);
        dbManager.openDB();
        ArrayList<Todo> todos = dbManager.fetchAll();


    }
}