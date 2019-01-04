package com.example.a86131.fromzero;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 作者： Garvey on 2016/6/13.
 * 邮箱： lianjiawei18@163.com
 */
public class FengShangFragment extends Fragment{
    // 缓存Fragment view
    private View rootView;
    private ListView listView2;
    private static FengShangFragment fengShangFragment;
    public FengShangFragment(){}
    public static FengShangFragment getNewInstance(){
        if (fengShangFragment ==null){
            fengShangFragment =new FengShangFragment();
        }
        return fengShangFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_fengshang, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        listView2 = (ListView)rootView.findViewById(R.id.list_view2);

        List<Map<String, Object>> list=getData();

        listView2.setAdapter(new ListViewAdapter1(getActivity(), list));
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("image", R.drawable.book);
        map.put("info", "学习" );
        map.put("time", "2小时15分" );
        map.put("value",1);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.bag);
        map.put("info", "工作" );
        map.put("time", "1小时10分" );
        map.put("value",2);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.team);
        map.put("info", "社团" );
        map.put("time", "0小时45分" );
        map.put("value",3);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.sport);
        map.put("info", "运动" );
        map.put("time", "0小时25分" );
        map.put("value",4);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.game);
        map.put("info", "娱乐" );
        map.put("time", "0小时30分" );
        map.put("value",5);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.bed);
        map.put("info", "休息" );
        map.put("time", "1小时15分" );
        map.put("value",6);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.love);
        map.put("info", "恋爱" );
        map.put("time", "0小时0分" );
        map.put("value",7);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("image", R.drawable.other);
        map.put("info", "旅游" );
        map.put("time", "0小时0分" );
        map.put("value",8);
        list.add(map);

        return list;
    }

}
