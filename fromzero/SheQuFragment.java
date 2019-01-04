package com.example.a86131.fromzero;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * 作者： Garvey on 2016/6/13.
 * 邮箱： lianjiawei18@163.com
 */
public class SheQuFragment extends Fragment {

    private View rootView;
    private static SheQuFragment sheQuFragment;
    public SheQuFragment(){}
    public static SheQuFragment getNewInstance(){
        if (sheQuFragment ==null){
            sheQuFragment =new SheQuFragment();
        }
        return sheQuFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_shequ, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
       Button b1=(Button)rootView.findViewById(R.id.bingtu);
       Button b2=(Button)rootView.findViewById(R.id.zhutu);
       Button b3=(Button)rootView.findViewById(R.id.xiantu);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),Main4Activity.class);
               getActivity().startActivity(intent);
           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),Main5Activity.class);
               getActivity().startActivity(intent);
           }
       });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
