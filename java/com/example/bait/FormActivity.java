package com.example.bait;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.Toast;

import com.example.bait.database.DBManager;
import com.example.bait.database.Todo;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FormActivity extends AppCompatActivity {

    TextInputLayout title;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        title = findViewById(R.id.textInputLayout);
        button = findViewById(R.id.btn);

        title.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (title.getEditText().getText().toString().length() > 3){
                    title.setError("");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        button.setOnClickListener(v -> {
            if(title.getEditText().getText().toString().isEmpty()){
                title.setError("Abey saale kuch to likh");
            }else {
                DBManager dbManager = new DBManager(this);
                dbManager.openDB();
                Todo todo = new Todo();
                todo.setTitle(title.getEditText().getText().toString());
                long id = dbManager.insert(todo);

                if (id > 0){
                    Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FormActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }



        });




    }
}