package com.bawie.duqilin20191203.view.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.bawie.duqilin20191203.R;
import com.bawie.duqilin20191203.base.BaseFragment;
import com.bawie.duqilin20191203.util.NetUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends BaseFragment {

    private ImageView iv;

    @Override
    protected void initView(View inflate) {
        iv = inflate.findViewById(R.id.iv);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_other;
    }

    @Override
    protected void initData() {
        if (NetUtil.getInstance().isWang(this)){

        }else {
            iv.setVisibility(View.VISIBLE);
        }
    }

}
