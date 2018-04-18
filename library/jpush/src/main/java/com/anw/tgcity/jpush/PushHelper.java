package com.anw.tgcity.jpush;

import android.content.Context;

import cn.jpush.android.api.JPushInterface;

public class PushHelper {
    public static void init(Context context, boolean isDebug) {
        JPushInterface.setDebugMode(isDebug);
        JPushInterface.init(context);
    }
}
