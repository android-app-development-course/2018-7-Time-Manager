package com.example.a86131.fromzero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a86131.fromzero.R;

import java.util.List;
import java.io.Serializable;
import java.util.Map;

public class ListViewAdapter1 extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public ListViewAdapter1(Context context, List<Map<String, Object>> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);    }
    /**     * 组件集合，对应list.xml中的控件     * @author Administrator     */
    public final class Zujian{
        public ImageView image;
        public TextView time;
        public TextView info;
        public int value;
    }    @Override
    public int getCount() {
        return data.size();    }
    /**     * 获得某一位置的数据     */
    @Override
    public Object getItem(int position) {        return data.get(position);    }
    /**     * 获得唯一标识     */    @Override
    public long getItemId(int position) {        return position;    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.tong_listview_item, null);
            zujian.image=(ImageView)convertView.findViewById(R.id.image);
            zujian.info=(TextView)convertView.findViewById(R.id.tong_name);
            zujian.time=(TextView) convertView.findViewById(R.id.tong_time);
            convertView.setTag(zujian);        }
        else{ zujian=(Zujian)convertView.getTag();        }
        //绑定数据
        zujian.image.setBackgroundResource((Integer)data.get(position).get("image"));
        zujian.info.setText((String)data.get(position).get("info"));
        zujian.time.setText((String)data.get(position).get("time"));
        return convertView;    }




}
