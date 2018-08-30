package com.example.trivinjperera.appname.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String TODO_TABLE_NAME = "todo";
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String NOTES_TABLE_NAME = "notes";

    public static final String TODO_COLUMN_TITLE = "title";
    public static final String TODO_COLUMN_DATE = "date";
    public static final String TODO_COLUMN_TIME = "time";
    public static final String TODO_COLUMN_NOTE = "note";

    public static final String EVENTS_COLUMN_DATE = "date";
    public static final String EVENTS_COLUMN_TIME = "time";
    public static final String EVENTS_COLUMN_TITLE = "title";
    public static final String EVENTS_COLUMN_NOTE = "note";

    public static final String NOTES_DATE = "date";
    public static final String NOTES_TITLE = "title";
    public static final String NOTES_CONTENT = "content";


    public static final String CONTACTS_COLUMN_EMAIL = "email";
    public static final String CONTACTS_COLUMN_STREET = "street";
    public static final String CONTACTS_COLUMN_CITY = "place";
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    private HashMap hp;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "create table "+ TODO_TABLE_NAME +
                "(title text, date text,time text,note text)");
        sqLiteDatabase.execSQL( "create table "+ EVENTS_TABLE_NAME +
                "(date text, time text,title text,note text)");
        sqLiteDatabase.execSQL( "create table "+ NOTES_TABLE_NAME+
                "(date text, title text,note text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS todo");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS notes");
        onCreate(sqLiteDatabase);
    }

    public boolean insertTodoItem (String title, String date, String time, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("note", note);
        db.insert("todo", null, contentValues);
        return true;
    }
    public boolean insertEventItem (String date, String time, String title, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("title", title);
        contentValues.put("note", note);
        db.insert("todo", null, contentValues);
        return true;
    }
    public boolean insertNoteItem (String date, String time, String title, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("title", title);
        contentValues.put("note", note);
        db.insert("todo", null, contentValues);
        return true;
    }

    public Cursor getTodoData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from todo", null );
        return res;
    }
    public Cursor getEventsOnDate(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from events where date="+date+"", null );
        return res;
    }

    public Cursor getNotesData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from notes", null );
        return res;
    }

    public boolean updateTodo (String title, String date, String time, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("note", note);
        db.update("todo", contentValues, "time = ? ", new String[] { time } );
        return true;
    }
    public boolean updateEvents (String date, String time, String title, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("title", title);
        contentValues.put("note", note);
        db.update("events", contentValues, "time = ? ", new String[] { time } );
        return true;
    }
    public boolean updateNotes (String date, String time, String title, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("title", title);
        contentValues.put("note", note);
        db.update("notes", contentValues, "time = ? ", new String[] { time } );
        return true;
    }
    public Integer deleteTodoItem (String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("todo",
                "time = ? ",
                new String[] { time });
    }
    public Integer deleteEventItem (String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("events",
                "time = ? ",
                new String[] { time });
    }
    public Integer deleteNoteItem (String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("notes",
                "time = ? ",
                new String[] { time });
    }
}
