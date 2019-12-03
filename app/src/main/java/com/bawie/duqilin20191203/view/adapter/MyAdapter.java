package com.bawie.duqilin20191203.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.duqilin20191203.R;
import com.bawie.duqilin20191203.model.bean.Bean;
import com.bawie.duqilin20191203.util.NetUtil;

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
            convertView = View.inflate(parent.getContext(),R.layout.item,null);
            viewHolder.image = convertView.findViewById(R.id.im);
            viewHolder.name = convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Bean.ShopGridDataBean shopGridDataBean = shopGridData.get(position);
        viewHolder.name.setText(shopGridDataBean.getTitle());
        String imageurl = shopGridDataBean.getImageurl();
        NetUtil.getInstance().getPath(imageurl,viewHolder.image);
        return convertView;
    }
    class ViewHolder{
        private ImageView image;
        private TextView name;
    }
}
