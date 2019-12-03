package com.bawie.duqilin20191203.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.bawie.duqilin20191203.R;
import com.bawie.duqilin20191203.base.BaseActivity;
import com.bawie.duqilin20191203.view.fragment.OtherFragment;
import com.bawie.duqilin20191203.view.fragment.ShopingCartFragment;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> list;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        OtherFragment otherFragment1 = new OtherFragment();
        OtherFragment otherFragment2 = new OtherFragment();
        OtherFragment otherFragment3 = new OtherFragment();
        ShopingCartFragment shopingCartFragment = new ShopingCartFragment();
        OtherFragment otherFragment5 = new OtherFragment();
        list.add(otherFragment1);
        list.add(otherFragment2);
        list.add(otherFragment3);
        list.add(shopingCartFragment);
        list.add(otherFragment5);
        //设置适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        //找控件
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
        //设置联动
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置点击切换
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt01:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.bt02:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.bt03:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.bt04:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.bt05:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return com.bawie.duqilin20191203.R.layout.activity_home;
    }

    public void tiao(){
        viewPager.setCurrentItem(0);
    }
}
