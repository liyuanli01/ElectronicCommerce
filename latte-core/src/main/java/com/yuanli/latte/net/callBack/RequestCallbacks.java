package com.yuanli.latte.net.callBack;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ElectronicCommerce
 * 注意实现自己项目的callback
 * @author liyuanli
 * @data 2018/5/24
 */

public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILFURE;

    public RequestCallbacks(IRequest request, ISuccess success, IError error, IFailure failfure) {
        REQUEST = request;
        SUCCESS = success;
        ERROR = error;
        FAILFURE = failfure;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){
            if(call.isExecuted()){
                if (SUCCESS!=null){
                    SUCCESS.onSuccess(response.body());
                }
            }
        }else {
            if (ERROR!=null){
                ERROR.onError(response.code(),response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable throwable) {
        if (FAILFURE!=null){
            FAILFURE.onFailure();
        }
        if (REQUEST!=null){
            REQUEST.onRequestEnd();
        }
    }
}
