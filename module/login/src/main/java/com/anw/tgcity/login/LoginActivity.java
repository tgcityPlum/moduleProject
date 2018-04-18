package com.anw.tgcity.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.anw.tgcity.baselibrary.util.ActivityIntentUtils;

import cn.liyula.chenw.login.R;

/**
 * 登录界面
 */
@Route(path = ActivityIntentUtils.Login.FLAG_LOGIN)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
