package com.yuanli.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.yuanli.latte.activitys.ProxyActivity;
import com.yuanli.latte.delegate.LatteDelegate;
import com.yuanli.latte.ec.sign.ISignListener;
import com.yuanli.latte.ec.sign.SignInDelegate;

/**
 * @author Administrator
 */
public class ExampleActivity extends ProxyActivity implements ISignListener{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignInDelegate();
        //return new ExampleDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {

    }
}
