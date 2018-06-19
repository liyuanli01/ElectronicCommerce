package com.yuanli.latte.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * ElectronicCommerce
 * 不想直接创造他，加上abstact
 * @author liyuanli
 * @data 2018/6/14
 */

public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        //这个必须写在onCreate中
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(),this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        //再写一次，保证在各个手机中万无一失
        LatteWeChat.getInstance().getWXAPI().handleIntent(getIntent(),this);
    }
}
