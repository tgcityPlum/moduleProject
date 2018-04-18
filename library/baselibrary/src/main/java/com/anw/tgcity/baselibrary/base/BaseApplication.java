package com.anw.tgcity.baselibrary.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Lenovo on 2018/4/18.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openLog();//打开日志
        ARouter.openDebug();//打开debug调试
        ARouter.init(this);//初始化ARouter
    }
}
