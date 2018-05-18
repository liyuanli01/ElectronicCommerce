package com.yuanli.festec.example;

import android.util.Log;

import com.yuanli.latte.activitys.ProxyActivity;
import com.yuanli.latte.delegate.LatteDelegate;

/**
 * @author Administrator
 */
public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        Log.i("TAG", "setLayout: come");
        return new ExampleDelegate();
    }

}
