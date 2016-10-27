package com.feicui.fragmentandviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.feicui.fragmentandviewpager.fragment.FragmentOne;
import com.feicui.fragmentandviewpager.fragment.FragmentThree;
import com.feicui.fragmentandviewpager.fragment.FragmentTwo;

import java.util.ArrayList;

/**
 * Created by mooon on 2016/10/27.
 */

public class Two_activity extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    private ArrayList<String> titlelist =new ArrayList<>();
    //参数列表需要一个Fragment管理器
    private FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        @Override
        public int getCount() {
            return 3;
        }
        //对应的title
        @Override
        public String getPageTitle(int position) {
            return titlelist.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
                default:
                    throw new RuntimeException("数据异常");
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_activity);
        tableLayout = (TabLayout) findViewById(R.id.two_table);
        viewPager = (ViewPager) findViewById(R.id.two_viewpager);
        titlelist.add("nihao");
        titlelist.add("buhao ");
        titlelist.add("hehe");
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);

    }
}
