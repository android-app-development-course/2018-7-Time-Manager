package com.example.a86131.fromzero;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity {
    MyHelper myHelper;
    MediaPlayer mMediaPlayer;
    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
    private int hh;
    private int yourChoice;
    boolean playing=false;
    boolean flag=true;
    private String ba;
    private CountDownProgressBar cpb;
    private TimeDownView tdv;
    String what[]={"study","work","home","sport","game","bed","love","visit"};
    long times[]={60000,300000,600000,1200000,1800000,2400000,3600000};



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);
        setContentView(R.layout.activity_main3);

        myHelper=new MyHelper(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏标题栏
        getSupportActionBar().hide();//隐藏标题栏
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        hh=bundle.getInt("key");
        TextView textView=(TextView)findViewById(R.id.t1);
        TextView textView1=(TextView)findViewById(R.id.t2);
        wenzi(textView,textView1,hh);
        final Button btn_start=findViewById(R.id.button1);
       ImageView shezhi=(ImageView)findViewById(R.id.shezhi);
        cpb=(CountDownProgressBar)findViewById(R.id.cpb_countdown);
        tdv=(TimeDownView)findViewById(R.id.tdv);
        tdv.invalidate(times[yourChoice]);
        final ImageView imageView=(ImageView)findViewById(R.id.music);
        mMediaPlayer=MediaPlayer.create(Main3Activity.this,R.raw.conway);
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialog();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!playing){
                    playing=true;
                    imageView.setImageResource(R.drawable.music2);
                    mMediaPlayer.start();
                }
                else{
                    playing=false;
                    imageView.setImageResource(R.drawable.music1);
                    mMediaPlayer.pause();
                }
            }
        });

            btn_start.setOnClickListener(new View.OnClickListener() {
                SQLiteDatabase db;
                ContentValues values;
                public void onClick(View v) {
                    if(flag){
                        btn_start.setText("结束");
                        flag=false;
                        switch (yourChoice){
                            case 0:win(times[0]);break;
                            case 1:win(times[1]);break;
                            case 2:win(times[2]);break;
                            case 3:win(times[3]);break;
                            case 4:win(times[4]);break;
                            case 5:win(times[5]);break;
                            case 6:win(times[6]);break;
                        }

                    }
                    else{
                        if(tdv.isTimeDownOver()){
                            db=myHelper.getWritableDatabase();
                            values=new ContentValues();
                            values.put("name",what[yourChoice]);
                            values.put("time",times[yourChoice]);
                            values.put("data1",getTime());
                            db.insert("information",null,values);
                            db.close();
                            showWaitingDialog();
                            //将日期+类型+时长->数据库内
                        }
                        else {
                            showNormalDialog();

                        }
                    }

                }
            });

    }
    public boolean onKeyDown( int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_BACK:

            case KeyEvent.KEYCODE_HOME:

            case KeyEvent.KEYCODE_MENU:

                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }
    public void win(long h){
        int a=(int)h;
        tdv.startTime(h);
        cpb.setDuration(a, new CountDownProgressBar.OnFinishListener() {
            @Override
            public void onFinish() {
                Toast.makeText(Main3Activity.this, "完成了", Toast.LENGTH_SHORT).show();
            }
        });

    }
   public void wenzi(TextView t1,TextView t2,int h){
        switch (h)
        {
            case 1:
                t1.setText("学习ing");
                t2.setText("“好好学习，天天向上！”");
                break;
            case 2:
                t1.setText("工作ing");
                t2.setText("“高效工作，绝不加班！”");
                break;
            case 3:
                t1.setText("社团ing");
                t2.setText("“开拓视野，锻炼能力！”");
                break;
            case 4:
                t1.setText("运动ing");
                t2.setText("“锻炼身体，健康生活！”");
                break;
            case 5:
                t1.setText("娱乐ing");
                t2.setText("“娱乐时光，尽情享受！”");
                break;
            case 6:
                t1.setText("休息ing");
                t2.setText("“好好休息，佛系生活！”");
                break;
            case 7:
                t1.setText("约会ing");
                t2.setText("“呵护爱情，甜蜜约会！”");
                break;
            case 8:
                t1.setText("旅游ing");
                t2.setText("“旅游观光，别番风味！”");
                break;
            default:break;
        }
    }
    //单选对话框（多个选项）
    private void showSingleChoiceDialog(){
        final String[] items = { "1分钟","5分钟","10分钟","20分钟","30分钟" ,"40分钟","60分钟"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(Main3Activity.this);
        singleChoiceDialog.setTitle("选择你喜欢的时间");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            tdv.invalidate(times[yourChoice]);
                            Toast.makeText(Main3Activity.this,
                                    "你选择了" + items[yourChoice],
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        singleChoiceDialog.show();
    }
    //两个按钮的对话框
    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(Main3Activity.this);
        normalDialog.setTitle("温馨提示");
        normalDialog.setMessage("确定退出不统计此次时间");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        Main3Activity.this.finish();
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }
    //等待对话框
    private void showWaitingDialog() {
        /* 等待Dialog具有屏蔽其他控件的交互能力
         * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
         * 下载等事件完成后，主动调用函数关闭该Dialog
                */
        final ProgressDialog waitingDialog=
                new ProgressDialog(Main3Activity.this);
        waitingDialog.setTitle("正在为您修改统计数据");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                finish();
                waitingDialog.dismiss();
                t.cancel();
            }
        }, 3000);
    }
    String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
    public void onDestroy(){
        mMediaPlayer.stop();
        super.onDestroy();
    }
}
