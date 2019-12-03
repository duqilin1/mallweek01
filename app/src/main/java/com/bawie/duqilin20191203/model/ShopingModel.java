package com.bawie.duqilin20191203.model;

import com.bawie.duqilin20191203.contract.IShopingContract;
import com.bawie.duqilin20191203.model.bean.Bean;
import com.bawie.duqilin20191203.util.NetUtil;
import com.google.gson.Gson;

/*
 *@auther:杜其林
 *@Date: 2019/12/3
 *@Time:9:21
 *@Description:${DESCRIPTION}
 * */
public class ShopingModel {
    public void getShopingData(final IShopingContract.IModel iModel){
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.HttpUtil() {
            @Override
            public void ongetJson(String json) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                iModel.onShopingSuccess(bean);
            }

            @Override
            public void onShiBai(String throwable) {
                iModel.onShopingFailure(throwable);
            }
        });
    }
}
