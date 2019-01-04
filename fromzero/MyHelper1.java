package com.example.a86131.fromzero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper1 extends SQLiteOpenHelper {
    public MyHelper1(Context context){
        super(context,"itcast1.db",null,2);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE diary(_id INTEGER PRIMARY KEY AUTOINCREMENT,title VARCHAR(20),time VARCHAR(20),data TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVerson){}
}
