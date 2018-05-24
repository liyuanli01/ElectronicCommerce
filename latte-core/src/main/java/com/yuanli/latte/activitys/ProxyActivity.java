package com.yuanli.latte.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;

import com.yuanli.latte.R;
import com.yuanli.latte.delegate.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * ElectronicCommerce
 *
 * 主activity会继承它
 * 注意SupportActivity不是android官方support v4的包；
 *
 * @author liyuanli
 * @data 2018/3/9
 */

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("TAG", "ProxyActivity: come");
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);

        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
