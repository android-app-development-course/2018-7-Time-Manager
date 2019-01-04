package com.example.a86131.fromzero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 作者： Garvey on 2016/6/13.
 * 邮箱： lianjiawei18@163.com
 */
public class ShouYeFragment extends Fragment{
    // 缓存Fragment view
    private ListView listView;
    private View rootView;
    private static ShouYeFragment shouYeFragment;
    public ShouYeFragment(){}
    public static ShouYeFragment getNewInstance(){
        if (shouYeFragment ==null){
            shouYeFragment =new ShouYeFragment();
        }
        return shouYeFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_shouye, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        listView = (ListView)rootView.findViewById(R.id.list_view);

        List<Map<String, Object>> list=getData();

        listView.setAdapter(new ListViewAdapter(getActivity(), list));

        return rootView;

    }

    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image", R.drawable.book);
            map.put("info", "好好学习，天天向上！" );
            map.put("value",1);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.bag);
            map.put("info", "高效工作，绝不加班！" );
            map.put("value",2);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.team);
            map.put("info", "开拓视野，锻炼能力！" );
            map.put("value",3);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.sport);
            map.put("info", "锻炼身体，健康生活！" );
            map.put("value",4);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.game);
            map.put("info", "娱乐时光，尽情享受！" );
            map.put("value",5);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.bed);
            map.put("info", "好好休息，佛系生活！" );
            map.put("value",6);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.love);
            map.put("info", "呵护爱情，甜蜜约会！" );
            map.put("value",7);
            list.add(map);
            map=new HashMap<String, Object>();
            map.put("image", R.drawable.other);
            map.put("info", "旅游观光，别番风味！" );
            map.put("value",8);
            list.add(map);

            return list;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();
    }
}


