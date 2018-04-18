package com.anw.tgcity.testmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.anw.tgcity.baselibrary.util.ActivityIntentUtils;
import com.anw.tgcity.testmvp.R;
@Route(path = ActivityIntentUtils.Home.FLAG_MAIN2)
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
