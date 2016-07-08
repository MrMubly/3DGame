package muble.com.a3dgame.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/7/5.
 */
public class IsNetConnecteUtils {
    public static boolean isConnect(Activity activity){
        boolean flag=false;
        //获得连接的管理对象
        ConnectivityManager connectivityManager=(ConnectivityManager)activity.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
       if (connectivityManager==null){
           return flag;
       }
        //根据连接的管理对象得到网络的信息对象
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        //如果连接的信息对象不为空，或连接的信息对象是活动的，说明网络连接成功
        if (networkInfo!=null||networkInfo.isAvailable()){
            flag=true;
        }
        return flag;
    }
}
