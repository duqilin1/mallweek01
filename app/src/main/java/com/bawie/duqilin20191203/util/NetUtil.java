package com.bawie.duqilin20191203.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *@auther:杜其林
 *@Date: 2019/12/3
 *@Time:9:41
 *@Description:${DESCRIPTION}
 * */
public class NetUtil {
     private static NetUtil netUtil = new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }

    //从网络上获取json
    public void getJson(final String connter, final HttpUtil httpUtil){
        new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPostExecute(String values) {
                if (TextUtils.isEmpty(values)){
                    httpUtil.onShiBai("请求失败");
                }else {
                    httpUtil.ongetJson(values);
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                String json = "";
                InputStream inputStream = null;
                try {
                    URL url = new URL(connter);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200){
                        inputStream = httpURLConnection.getInputStream();
                        json = io2String(inputStream);
                    }else {
                        Log.e("xx", "请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return json;
            }
        }.execute();
    }
    //转字符串
    private String io2String(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }
    //从网络上获取图片
    public void getPath(final String a, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap = null;
                InputStream inputStream = null;
                try {
                    URL url = new URL(a);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200){
                        inputStream = httpURLConnection.getInputStream();
                        bitmap = io2Bitmap(inputStream);
                    }else {
                        Log.e("xx", "请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return bitmap;
            }
        }.execute();
    }
    //转图片
    private Bitmap io2Bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }
    //判断是否有网
    public boolean isWang(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        }else {
            return false;
        }
    }
    //判断是否有网
    public boolean isWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == connectivityManager.TYPE_WIFI) {
            return true;
        }else {
            return false;
        }
    }
    //判断是否有网
    public boolean isMobile(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == connectivityManager.TYPE_MOBILE) {
            return true;
        }else {
            return false;
        }
    }
    //定义接口
    public interface HttpUtil{
        void ongetJson(String json);

        void onShiBai(String throwable);
    }
}
