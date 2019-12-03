package com.bawie.duqilin20191203.view.fragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawie.duqilin20191203.R;
import com.bawie.duqilin20191203.base.BaseFragment;
import com.bawie.duqilin20191203.contract.IShopingContract;
import com.bawie.duqilin20191203.model.bean.Bean;
import com.bawie.duqilin20191203.presenter.ShopingPresenter;
import com.bawie.duqilin20191203.view.activity.HomeActivity;
import com.bawie.duqilin20191203.view.adapter.MyAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopingCartFragment extends BaseFragment implements IShopingContract.IView {

    private Button button;
    private GridView gridView;

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.bt);
        gridView = inflate.findViewById(R.id.gv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity homeActivity = (HomeActivity) getActivity();
                homeActivity.tiao();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_shoping_cart;
    }

    @Override
    protected void initData() {
        ShopingPresenter shopingPresenter = new ShopingPresenter();
        shopingPresenter.getShopingData(this);
    }

    @Override
    public void onShopingSuccess(Bean bean) {
        List<Bean.ShopGridDataBean> shopGridData = bean.getShopGridData();
        MyAdapter myAdapter = new MyAdapter(shopGridData);
        gridView.setAdapter(myAdapter);
    }

    @Override
    public void onShopingFailure(String throwable) {
        Toast.makeText(getActivity(),"请求失败",Toast.LENGTH_SHORT).show();
    }
}
