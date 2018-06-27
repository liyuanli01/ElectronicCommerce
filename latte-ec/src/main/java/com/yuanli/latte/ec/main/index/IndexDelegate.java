package com.yuanli.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yuanli.latte.delegate.bottom.BottomItemDelegate;
import com.yuanli.latte.ec.R;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/27
 */

public class IndexDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
