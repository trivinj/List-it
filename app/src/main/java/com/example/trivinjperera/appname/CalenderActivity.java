package com.example.trivinjperera.appname;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trivinjperera.appname.DB.DBHelper;
import com.example.trivinjperera.appname.listview_adapters.EventsAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import static com.example.trivinjperera.appname.R.id.btnEditEvent;

@RequiresApi(api = Build.VERSION_CODES.O)
public class CalenderActivity extends AppCompatActivity {
    FloatingActionButton btnEditEvent;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private CalendarView calendarView;
    private DBHelper mydb;
    ArrayAdapter<String> itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        calendarView = findViewById(R.id.calendarView);
        final ListView listView = (ListView) findViewById(R.id.todoList);
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        String parts[] = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        long milliTime = calendar.getTimeInMillis();
        calendarView.setDate (milliTime, true, true);

        //----------------------------------------------------------------

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month, int date) {
               filterEventsOnDate(year +"/"+ month +"/"+ date, listView);
            }
        });

        final Intent editEvent = new Intent(this, CalenderEditActivity.class);
        btnEditEvent = findViewById(R.id.btnEditEvent);
        btnEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(editEvent);
            }
        });
    }

    private void filterEventsOnDate(String date, ListView listView){
        //final EventsAdapter adapter = new EventsAdapter(this, R.layout.event_layout, list);
        //list.setAdapter(adapter);
        itemsAdapter = new ArrayAdapter<String>(this, R.layout.event_layout, (List<String>) mydb.getEventsOnDate(date));
        listView.setAdapter(itemsAdapter);
    }
}
