package com.example.trivinjperera.appname;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trivinjperera.appname.DB.DBHelper;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class TodoEditActivity extends AppCompatActivity {
    private Button btnSave;
    private EditText editTitle, editDate, editTime, editNote;
    private DBHelper myDb;


    @  Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_edit);
        editTitle = findViewById(R.id.title);
        editDate = findViewById(R.id.date);
        editTime = findViewById(R.id.time);
        editNote = findViewById(R.id.note);
        btnSave = findViewById(R.id.save);
        myDb = new DBHelper(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean status = myDb.insertTodoItem(editTitle.getText().toString(), editDate.getText().toString(), editTime.getText().toString(), editNote.getText().toString());
                if(status == true){
                    Toast.makeText(getApplicationContext(), "Activity Added!",Toast.LENGTH_SHORT).show();
                    editTitle.setText("");
                    editDate.setText("");
                    editTime.setText("");
                    editTime.setText("");
                }

            }
        });
    }
}
