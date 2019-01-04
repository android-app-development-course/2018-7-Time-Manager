package com.example.a86131.fromzero;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 作者： Garvey on 2016/6/13.
 * 邮箱： lianjiawei18@163.com
 */
public class BaseFragment extends Fragment{
    // 缓存Fragment view
    private View rootView;
    private static BaseFragment baseFragment;
    public BaseFragment(){}
    public static BaseFragment getNewInstance(){
        if (baseFragment ==null){
            baseFragment =new BaseFragment();
        }
        return baseFragment;
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
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
