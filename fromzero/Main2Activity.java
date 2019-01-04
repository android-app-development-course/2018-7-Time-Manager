package com.example.a86131.fromzero;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    /**
     * 底部导航栏的widdget
     */
    private RadioGroup mNavGroup;
    private FragmentTransaction mTransaction;
    /**
     * 五个Fragments
     */
    Fragment syFragemnt, gwFragment, fsFragment, sqFragment, wdFragment;
    public static final int VIEW_SHOUYE_INDEX = 0;
    public static final int VIEW_GOUWU_INDEX = 1;
    public static final int VIEW_FENGSHANG_INDEX = 2;
    public static final int VIEW_SHEQU_INDEX = 3;
    public static final int VIEW_WODE_INDEX = 4;
    private int temp_position_index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏标题栏
        getSupportActionBar().hide();//隐藏标题栏
        initView();

    }

    private void initView() {
        mNavGroup = (RadioGroup) findViewById(R.id.id_navcontent);
        syFragemnt = ShouYeFragment.getNewInstance();
        gwFragment = GouWuFragment.getNewInstance();
        fsFragment = FengShangFragment.getNewInstance();
        sqFragment = SheQuFragment.getNewInstance();
        wdFragment = WoDeFragment.getNewInstance();
        //显示
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.id_fragment_content, syFragemnt);
        mTransaction.commit();
    }
    public void switchView(View view) {
        switch (view.getId()) {
            case R.id.id_nav_btshouye:
                if (temp_position_index != VIEW_SHOUYE_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content, syFragemnt);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_SHOUYE_INDEX;
                break;
            case R.id.id_nav_btgouwu:
                if (temp_position_index != VIEW_GOUWU_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content, gwFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_GOUWU_INDEX;
                break;
            case R.id.id_nav_btfengshang:
                if (temp_position_index != VIEW_FENGSHANG_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content, fsFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_FENGSHANG_INDEX;
                break;
            case R.id.id_nav_btshequ:
                if (temp_position_index != VIEW_SHEQU_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content, sqFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_SHEQU_INDEX;
                break;
            case R.id.id_nav_btwode:
                if (temp_position_index != VIEW_WODE_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.id_fragment_content, wdFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_WODE_INDEX;
                break;
        }
    }

}

