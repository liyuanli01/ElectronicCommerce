package com.yuanli.festec.example;

import android.app.Application;

import com.yuanli.latte.app.Latte;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/3/7
 */

public class ExampleApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://192.168.1.167/")
                .configure();
    }
}
