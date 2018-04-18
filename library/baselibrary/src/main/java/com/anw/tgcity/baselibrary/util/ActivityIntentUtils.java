package com.anw.tgcity.baselibrary.util;

/**
 * Created by Lenovo on 2018/4/18.
 */

public class ActivityIntentUtils {

    /**
     * 主module
     */
    public class Home {
        //基础标识
        static final String FLAG_HOME_INDEX = "/home/";

        //跳转Main2Activity类的表示
        public static final String FLAG_MAIN2 = FLAG_HOME_INDEX + "Main2Activity";
    }

    /**
     * 登录module
     */
    public class Login{
        //基础标识
        static final String FLAG_LOGIN_INDEX = "/login/";

        //跳转LoginActivity类的表示
        public static final String FLAG_LOGIN = FLAG_LOGIN_INDEX + "LoginActivity";
    }
}
