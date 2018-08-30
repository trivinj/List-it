package com.example.trivinjperera.appname;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotesActivity extends AppCompatActivity {
    FloatingActionButton btnEditNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        final Intent startEditnote = new Intent(this, NotesEditActivity.class);
        btnEditNote = findViewById(R.id.editNote);
        btnEditNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startEditnote);
            }
        });
      /*  final Intent startNote = new Intent(this, NotesEditActivity.class);
        btnEditNote = findViewById(R.id.btnEdit);
        btnEditNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startNote);
            }
        });*/
    }

}
