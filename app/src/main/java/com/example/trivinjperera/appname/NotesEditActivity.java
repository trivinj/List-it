package com.example.trivinjperera.appname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotesEditActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_edit);

        button =(Button) findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                openMain2Activity();
            }
        });
    }
    public void openMain2Activity(){
        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }
}

