package com.yuanli.latte.wechat.templates;

import com.yuanli.latte.wechat.LatteWeChat;

/**
 * ElectronicCommerce
 * 模板类：为了生成我们的代码
 * @author liyuanli
 * @data 2018/6/14
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    /**
     * 微信返回来的时候其实是调起了这个模板生成之后的activity，而且不会自动取消
     * 也就是说，登录完了会回到我们不想回到的页。
     * 市面上大多数的处理方式：
     * 把这个activity设置成透明的，当回来的时候给他finish掉
     */
    @Override
    protected void onResume() {
        super.onResume();
        finish();
        //不需要有任何动画效果
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getmSignInCallback().onSignInSuccess(userInfo);
    }
}
