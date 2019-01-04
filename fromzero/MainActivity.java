package com.example.a86131.fromzero;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏标题栏
        getSupportActionBar().hide();//隐藏标题栏
        Thread myThread=new Thread(){
            @Override
            public void run() {
                try{

                    sleep(5000);
                    Intent it=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(it);
                    finish();
                }catch (Exception e){e.printStackTrace();}
            }
        };
        myThread.start();
    }
}
