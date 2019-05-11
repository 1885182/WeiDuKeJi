package com.wd.tech.net;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * @Author: zhang
 * @Date: 2019/5/9 16:15
 * @Description:
 */
public class NetWork{

    public static boolean netWork(Context context){

        //创建网络连接管理器
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return  info.isConnected();
    }
}
