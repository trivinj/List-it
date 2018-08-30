package com.example.trivinjperera.appname;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.trivinjperera.appname.DB.DBHelper;

import java.util.List;

public class TodoActivity extends AppCompatActivity {
    FloatingActionButton btnEdit;
    Button btnSave;
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private DBHelper mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        mydb = new DBHelper(this);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) mydb.getTodoData());
        final Intent startEdit = new Intent(this, TodoEditActivity.class);
        btnEdit = findViewById(R.id.btnEdit);
        ListView listView = (ListView) findViewById(R.id.todoList);
        listView.setAdapter(itemsAdapter);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startEdit);
            }
        });

    }
}
