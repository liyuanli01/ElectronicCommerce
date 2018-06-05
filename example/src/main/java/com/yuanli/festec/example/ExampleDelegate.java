package com.yuanli.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.yuanli.latte.delegate.LatteDelegate;
import com.yuanli.latte.net.RestClient;
import com.yuanli.latte.net.callBack.IError;
import com.yuanli.latte.net.callBack.IFailure;
import com.yuanli.latte.net.callBack.ISuccess;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/3/13
 */

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Toast.makeText(getContext(), "failure", Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String message) {
                        Toast.makeText(getContext(), "erro", Toast.LENGTH_LONG).show();
                    }
                })
                //.name()完整文件名或着下方两种
                //.dir()
                //.extension()
                //.build()
                //.download();最后download
                .build()
                .get();
    }
}
