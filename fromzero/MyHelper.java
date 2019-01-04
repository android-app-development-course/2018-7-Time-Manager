package com.example.a86131.fromzero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context,"itcast.db",null,2);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),data1 VARCHAR(20),time INTEGER )");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVerson){}
}
