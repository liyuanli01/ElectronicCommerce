package com.yuanli.latte.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yuanli.latte.app.ConfigKeys;
import com.yuanli.latte.app.Latte;
import com.yuanli.latte.wechat.callbacks.IWeChatSignInCallback;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/14
 */

public class LatteWeChat {

    public static final String APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    public static final String APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mSignInCallback = null;

    private static final class Holder {
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private LatteWeChat() {
        final Activity activity = Latte.getConfiguration(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity, null);
//        WXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        //true是校验，我们已经校验过了，所以写true
        WXAPI.registerApp(APP_ID);
    }

    /**
     * 不得不使用public又不想被之后的自己修改的话就加上final
     * 这样在虚拟机层会进行一定的优化，对自己的程序也是有好处的
     *
     * @return
     */
    public final IWXAPI getWXAPI() {
        return WXAPI;
    }

    public LatteWeChat onSignSuccess(IWeChatSignInCallback callback) {
        this.mSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getmSignInCallback() {
        return mSignInCallback;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }

}
