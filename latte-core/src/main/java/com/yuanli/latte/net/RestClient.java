package com.yuanli.latte.net;

import com.yuanli.latte.net.callBack.IError;
import com.yuanli.latte.net.callBack.IFailure;
import com.yuanli.latte.net.callBack.IRequest;
import com.yuanli.latte.net.callBack.ISuccess;
import com.yuanli.latte.net.callBack.RequestCallbacks;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * ElectronicCommerce
 * builder模式宿主
 * 考虑需要哪些参数？build模式创建
 *
 * @author liyuanli
 * @data 2018/5/18
 */

public class RestClient {

    /* 这里的参数一次构建完毕，决不允许更改  用final */
    private final String URL;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILFURE;
    private final RequestBody BODY;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IError error,
                      IFailure failfure,
                      RequestBody body) {
        URL = url;
        PARAMS.putAll(params);
        REQUEST = request;
        SUCCESS = success;
        ERROR = error;
        FAILFURE = failfure;
        BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback(){
        return new RequestCallbacks(
                REQUEST,
                SUCCESS,
                ERROR,
                FAILFURE
        );
    }

    public final void get(){
        request(HttpMethod.GET);
    }

    public final void post(){
        request(HttpMethod.POST);
    }
    public final void put(){
        request(HttpMethod.PUT);
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }

}
