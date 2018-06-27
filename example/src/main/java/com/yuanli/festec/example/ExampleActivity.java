package com.yuanli.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.yuanli.latte.activitys.ProxyActivity;
import com.yuanli.latte.app.Latte;
import com.yuanli.latte.delegate.LatteDelegate;
import com.yuanli.latte.ec.launcher.ILauncherListener;
import com.yuanli.latte.ec.launcher.LauncherDelegate;
import com.yuanli.latte.ec.launcher.OnLauncherFinishTag;
import com.yuanli.latte.ec.main.index.EcBottomDelegate;
import com.yuanli.latte.ec.sign.ISignListener;
import com.yuanli.latte.ec.sign.SignInDelegate;

/**
 * @author Administrator
 */
public class ExampleActivity extends ProxyActivity
        implements ISignListener, ILauncherListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //传入微信回调的activity
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegate() {
//        return new SignInDelegate();
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        getSupportDelegate().start(new EcBottomDelegate());
    }

    @Override
    public void onSignUpSuccess() {

    }


    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                //用户已登录
                getSupportDelegate().start(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                //用户未登录
                getSupportDelegate().start(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
