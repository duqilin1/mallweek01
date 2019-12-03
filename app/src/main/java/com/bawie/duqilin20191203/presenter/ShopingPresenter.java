package com.bawie.duqilin20191203.presenter;

import com.bawie.duqilin20191203.contract.IShopingContract;
import com.bawie.duqilin20191203.model.ShopingModel;
import com.bawie.duqilin20191203.model.bean.Bean;

/*
 *@auther:杜其林
 *@Date: 2019/12/3
 *@Time:9:42
 *@Description:${DESCRIPTION}
 * */ public class ShopingPresenter {
     public void getShopingData(final IShopingContract.IView iView){
         ShopingModel shopingModel = new ShopingModel();
         shopingModel.getShopingData(new IShopingContract.IModel() {
             @Override
             public void onShopingSuccess(Bean bean) {
                 iView.onShopingSuccess(bean);
             }

             @Override
             public void onShopingFailure(String throwable) {
                iView.onShopingFailure(throwable);
             }
         });
     }
}
