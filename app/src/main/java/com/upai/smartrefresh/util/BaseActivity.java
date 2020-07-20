package com.upai.smartrefresh.util;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onCreate());

        context = this;
        Log.d(TAG, "当前Activity是: " + getLocalClassName());

        init();
    }

    // 返回布局文件
    protected abstract int onCreate();

    // 初始化
    protected abstract void init();
}
