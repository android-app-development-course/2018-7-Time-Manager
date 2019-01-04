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

public class Main7Activity extends AppCompatActivity {
    private EditText tt1;
   private ImageView v1,v2;
    MyHelper1 myHelper1;
    private EditText tt2;
    String hh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myHelper1=new MyHelper1(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏标题栏
        getSupportActionBar().hide();//隐藏标题栏
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        hh=bundle.getString("key");
        tt1=(EditText)findViewById(R.id.biaoti1);
        tt2=(EditText)findViewById(R.id.neirong1);
        chishi(hh);
       v1=(ImageView)findViewById(R.id.shanchu);
        v2=(ImageView)findViewById(R.id.xiugai);
        v1.setOnClickListener(new View.OnClickListener() {
            SQLiteDatabase db;
            @Override
            public void onClick(View v) {
                db=myHelper1.getWritableDatabase();
                db.delete("diary","title=?",new String[]{hh});
                db.close();
                finish();
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            SQLiteDatabase db;
            ContentValues values;
            public void onClick(View v) {
                db=myHelper1.getWritableDatabase();
                values=new ContentValues();
                values.put("title",tt1.getText().toString());
                values.put("data",tt2.getText().toString());
                values.put("time",getTime());
                db.update("diary",values,"title=?",new String[]{hh});
                db.close();
                finish();
            }
        });
    }
    public void chishi(String values){
        SQLiteDatabase sb=myHelper1.getReadableDatabase();
        Cursor c=sb.query("diary",null,"title=?",new String[]{values},null,null,null);
        c.moveToNext();
        tt1.setText(c.getString(1));
        tt2.setText(c.getString(3));
        c.close();
        sb.close();

    }
    String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}
