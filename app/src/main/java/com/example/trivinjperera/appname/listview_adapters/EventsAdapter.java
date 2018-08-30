package com.example.trivinjperera.appname.listview_adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trivinjperera.appname.R;

import java.util.List;

public class EventsAdapter extends ArrayAdapter<String>{
    private Context context;
    List<String> events;
    public EventsAdapter(@NonNull Context context, int resource, List<String> events) {
        super(context, resource, events);
        this.events = events;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.event_layout, parent, false);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.event_title);
        TextView txtNote = (TextView) rowView.findViewById(R.id.event_note);
        txtTitle.setText(events.get(position));
        // change the icon for Windows and iPhone
        /*String s = values[position];
        if (s.startsWith("iPhone")) {
            imageView.setImageResource(R.drawable.no);
        } else {
            imageView.setImageResource(R.drawable.ok);
        }
        */
        return rowView;
    }
}
