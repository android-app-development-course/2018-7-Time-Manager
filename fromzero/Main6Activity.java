package com.example.a86131.fromzero;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main6Activity extends AppCompatActivity {
    ImageView wancheng;
    int y=0;

    MyHelper1 myHelper1;
    EditText text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myHelper1=new MyHelper1(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏标题栏
        getSupportActionBar().hide();//隐藏标题栏
        wancheng=(ImageView)findViewById(R.id.wancheng);
        text1=(EditText)findViewById(R.id.biaoti);
        text2=(EditText)findViewById(R.id.neirong);

        wancheng.setOnClickListener(new View.OnClickListener() {
            SQLiteDatabase db;
            ContentValues values;
            @Override
            public void onClick(View v) {
                db=myHelper1.getWritableDatabase();
                values=new ContentValues();
                values.put("title",text1.getText().toString());
                values.put("data",text2.getText().toString());
                values.put("time",getTime());
                db.insert("diary",null,values);
                db.close();
                finish();
            }
        });
    }

    String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}
