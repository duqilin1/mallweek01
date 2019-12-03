package com.bawie.duqilin20191203.contract;

import com.bawie.duqilin20191203.model.bean.Bean;

/*
 *@auther:杜其林
 *@Date: 2019/12/3
 *@Time:9:42
 *@Description:${DESCRIPTION}
 * */
public interface IShopingContract {
    interface IModel{
        void onShopingSuccess(Bean bean);

        void onShopingFailure(String throwable);
    }
    interface IView{
        void onShopingSuccess(Bean bean);

        void onShopingFailure(String throwable);
    }
}
