package com.example.a86131.fromzero;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 作者： Garvey on 2016/6/13.
 * 邮箱： lianjiawei18@163.com
 */
public class GouWuFragment extends Fragment{
    // 缓存Fragment view
    boolean isPause;
    MyHelper1 helper1;
    ListViewAdapter2 adapter2;
    private ListView listView2;
    private ImageView tianjia;
    private View rootView;

    private static GouWuFragment gouWuFragment;
    public GouWuFragment(){}
    public static GouWuFragment getNewInstance(){
        if (gouWuFragment ==null){
            gouWuFragment =new GouWuFragment();
        }
        return gouWuFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_gouwu, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        helper1=new MyHelper1(getActivity());
        tianjia=(ImageView)rootView.findViewById(R.id.tianjia);
        listView2 = (ListView)rootView.findViewById(R.id.list_view2);

        List<Map<String, Object>> list=getData();
        adapter2=new ListViewAdapter2(getActivity(),list);
        listView2.setAdapter(adapter2);
        tianjia.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Main6Activity.class);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }

    public List<Map<String, Object>> getData(){
        SQLiteDatabase db=helper1.getReadableDatabase();
        Cursor cursor=db.query("diary",null,null,null,null,null,null);

        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        Map<String, Object> map=new HashMap<String, Object>();
        while (cursor.moveToNext()){
            map=new HashMap<String, Object>();
            map.put("image",R.drawable.book);
            map.put("info", cursor.getString(1));
            map.put("time", cursor.getString(2) );
            list.add(map);
        }
        cursor.close();
        db.close();
        return list;
    }


}
