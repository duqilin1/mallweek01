package com.bawie.duqilin20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bawie.duqilin20191203.model.bean.Bean;

import java.util.List;

/*
 *@auther:杜其林
 *@Date: 2019/12/3
 *@Time:10:09
 *@Description:${DESCRIPTION}
 * */
public class MyAdapter extends BaseAdapter{

    private List<Bean.ShopGridDataBean> shopGridData;

    public MyAdapter(List<Bean.ShopGridDataBean> shopGridData) {

        this.shopGridData = shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder{

    }
}
