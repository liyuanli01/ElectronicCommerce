package com.yuanli.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.yuanli.latte.delegate.LatteDelegate;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/3/13
 */

public class ExampleDelegate extends LatteDelegate{

    @Override
    public Object setLayout() {
        Log.i("TAG", "setLayout: come");
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
