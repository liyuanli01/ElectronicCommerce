package com.yuanli.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;
import com.yuanli.latte.delegate.LatteDelegate;
import com.yuanli.latte.ec.R;
import com.yuanli.latte.ec.R2;
import com.yuanli.latte.net.RestClient;
import com.yuanli.latte.net.callBack.ISuccess;
import com.yuanli.latte.util.log.LatteLogger;
import com.yuanli.latte.wechat.LatteWeChat;
import com.yuanli.latte.wechat.callbacks.IWeChatSignInCallback;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/11
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.btn_sign_in)
    AppCompatButton btnSignIn = null;
    @BindView(R2.id.icon_sign_in_wechat)
    IconTextView iconSignInWechat = null;
    @BindView(R2.id.tv_link_sign_up)
    AppCompatTextView tvLink = null;

    private ISignListener mSignListenner = null;

    /**
     * me.yokeyword.fragmentation.SupportActivity里的onAttach()方法
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            mSignListenner= (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            //http://120.26.239.195:8011/Mobile/UserAPP/UserAppLogin?name=lilan&password=123456
            RestClient.builder()
                    .url("http://120.26.239.195:8011/Mobile/UserAPP/UserAppLogin?")
                    .params("name", mName.getText().toString())
                    .params("password", mPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignIn(response, mSignListenner);
                        }
                    })
                    .build()
                    .get();
        }
    }


    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat() {
        LatteWeChat.getInstance().onSignSuccess(new IWeChatSignInCallback() {
            @Override
            public void onSignInSuccess(String userInfo) {
                LatteLogger.json("WX_USER_PROFILE", userInfo.toString());
                Toast.makeText(getContext(),userInfo,Toast.LENGTH_LONG).show();
            }
        }).signIn();
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    private boolean checkForm() {

        final String name = mName.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少六位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

}
