package com.example.trivinjperera.appname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton  btnTodo, btnEvents, btnNotes, btnStats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {/**/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent startTodo = new Intent(this, TodoActivity.class);
        final Intent startEvents = new Intent(this, CalenderActivity.class);
        final Intent startNotes = new Intent(this, NotesActivity.class);
        final Intent startStats = new Intent(this, DiaryActivity.class);
        btnTodo = findViewById(R.id.todo);
        btnEvents = findViewById(R.id.events);
        btnNotes = findViewById(R.id.notes);
        btnStats = findViewById(R.id.stats);

        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startTodo);
            }
        });
        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startEvents);
            }
        });
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startNotes);
            }
        });
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startStats);
            }
        });
    }
}
