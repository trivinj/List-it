package com.example.trivinjperera.appname;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiaryActivity extends AppCompatActivity {
    FloatingActionButton btnEditDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);


        final Intent editDiary = new Intent(this, DiaryEditActivity.class);
        btnEditDiary = findViewById(R.id.btnEditDiary);
        btnEditDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(editDiary);
            }
        });

    }
}
