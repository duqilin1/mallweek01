package com.bawie.duqilin20191203.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@auther:杜其林
 *@Date: 2019/12/3
 *@Time:9:21
 *@Description:${DESCRIPTION}
 * */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutId();
}
