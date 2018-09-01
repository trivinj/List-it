package com.example.trivinjperera.appname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {
    private Button button2,button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        button2 =(Button) findViewById(R.id.buttonEdit);
        button3 =(Button) findViewById(R.id.buttonNew);
        button4 =(Button) findViewById(R.id.buttonDelete);
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                openNotesEditActivity();
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                openNotesEditActivity();
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Toast.makeText(NotesActivity.this, "The selected item was deleted", Toast.LENGTH_SHORT).show();
            }
        });

// ListView Sample Population
        final ListView listview = (ListView) findViewById(R.id.listView);
        String[] values = new String[] { "Read Chapter 2 in ICT book", "Goto the Supermarket", "Call the Doctor", "Book a rent-a-car"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                String str_item = listview.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), str_item,
                        Toast.LENGTH_SHORT).show();
            }});

    }

    public void openNotesEditActivity(){
        Intent intent = new Intent(this, NotesEditActivity.class);
        startActivity(intent);
    }


}
