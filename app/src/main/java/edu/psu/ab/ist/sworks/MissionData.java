package edu.psu.ab.ist.sworks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/*import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;*/

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import edu.psu.ab.ist.sworks.database.DatabaseSetup;

import static android.content.Context.MODE_PRIVATE;

public class MissionData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_data);
        SQLiteDatabase db = null;
        try {
            db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
            db.execSQL("DROP TABLE IF EXISTS myTable");
            db.execSQL("CREATE TABLE IF NOT EXISTS " + "myTable(LastName VARCHAR, FirstName VARCHAR, Age INT(3));");

            db.execSQL("INSERT INTO myTable VALUES ('dsad', 'dsa',21);");
            Cursor c = db.rawQuery("Select * FROM myTable", null);
            c.moveToFirst();
            Log.d("JOE", c.getString(c.getColumnIndex("FirstName")));
        }
        catch (Exception e){
            Log.d("Error:", e.toString());
        }
        finally{
            db.close();
        }
    }
/*
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + "myTable" + "( "
                + GPS_ID + " INTEGER PRIMARY KEY " + " )");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + "myTable" +"( " + GPS_ID + "GPS ID )" );
        Cursor c = sqLiteDatabase.rawQuery("Select * FROM myTable", null);
        c.moveToFirst();
        Log.d("David", c.getString(c.getColumnIndex("gpsID")));
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        // drops table if exists, and then calls onCreate which implements
        // our new schema
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        database.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(database);
    }*/
}