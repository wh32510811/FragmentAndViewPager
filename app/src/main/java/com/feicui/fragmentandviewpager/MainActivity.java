package com.feicui.fragmentandviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.feicui.fragmentandviewpager.fragment.FragmentOne;
import com.feicui.fragmentandviewpager.fragment.FragmentThree;
import com.feicui.fragmentandviewpager.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private Button btn1,btn2,btn3;
    private ViewPager viewPager;
    //参数列表需要获取一个Fragment管理器 getSupportFragmentManager
    private FragmentPagerAdapter adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
     //通过当前的position初始化Fragment。将Fragment填充到ViewPager中
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
                default:
                    throw new RuntimeException("数据异常");//最后这里需要抛一个运行时异常runException
            }
        }

        @Override
        public int getCount() {
            return 3;//这里返回的值是我们已知的Fragment数量
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);//viewPager设置上适配器
        viewPager.addOnPageChangeListener(this);//给ViewPager设置滑动监听，目的是为了显示Fragment
        btn1.setSelected(true);//首次进入默认选中第一个
        //下方btn设置监听，点击时切换页面
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    /**页面滑动时的监听*/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    /**页面选择时的监听*/
    @Override
    public void onPageSelected(int position) {
        //当选择Fragment时，同步设置下方按钮的旋转状态
        btn1.setSelected(position==0);
        btn2.setSelected(position==1);
        btn3.setSelected(position==2);
    }
    /**页面滑动状态变化时的监听*/
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**点击btn设置ViewPager当前视图*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                viewPager.setCurrentItem(0,true);//参数一是ViewPager的position,参数二为是否有滑动效果
                break;
            case R.id.btn2:
                viewPager.setCurrentItem(1,true);
                break;
            case R.id.btn3:
                viewPager.setCurrentItem(2,true);
                break;
        }
    }
}
