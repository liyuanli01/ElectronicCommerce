package com.yuanli.latte.net.callBack;


import android.os.Handler;

import com.yuanli.latte.ui.loader.LatteLoader;
import com.yuanli.latte.ui.loader.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ElectronicCommerce
 * 注意实现自己项目的callback
 *
 * @author liyuanli
 * @data 2018/5/24
 */
public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILFURE;
    private final LoaderStyle LOADER_STYLE;
    //static防止内存溢出
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IError error, IFailure failfure, LoaderStyle loaderStyle) {
        REQUEST = request;
        SUCCESS = success;
        ERROR = error;
        FAILFURE = failfure;
        LOADER_STYLE = loaderStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        if (LOADER_STYLE!=null){
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            },1000);
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable throwable) {
        if (FAILFURE != null) {
            FAILFURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
    }
}
