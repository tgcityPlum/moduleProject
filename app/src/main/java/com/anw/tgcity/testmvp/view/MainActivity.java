package com.anw.tgcity.testmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.anw.tgcity.baselibrary.util.ActivityIntentUtils;
import com.anw.tgcity.testmvp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        ARouter.getInstance()
        .build(ActivityIntentUtils.Login.FLAG_LOGIN)
//        .build(ActivityIntentUtils.Home.FLAG_MAIN2)
        .navigation();
    }
}
