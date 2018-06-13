package com.yuanli.latte.net;

import android.content.Context;

import com.yuanli.latte.net.callBack.IError;
import com.yuanli.latte.net.callBack.IFailure;
import com.yuanli.latte.net.callBack.IRequest;
import com.yuanli.latte.net.callBack.ISuccess;
import com.yuanli.latte.ui.loader.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * ElectronicCommerce
 * builder模式建造者
 * 加入RestClient中的参数并写上对应的方法
 *
 * @author liyuanli
 * @data 2018/5/21
 */

public class RestClientBuilder {
    private String mUrl = null;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();

    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IError mIError = null;
    private IFailure mIFailure = null;

    private RequestBody mBody = null;
    private File mfile;
    private Context mContext = null;
    private LoaderStyle mLoadStyle = null;

    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    /**
     * 不允许外部类来用它
     * 只允许RestClient使用
     * 构造器尽量缩小范围
     */
    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mfile = file;
        return this;
    }

    public final RestClientBuilder file(String file) {
        this.mfile = new File(file);
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mContext = context;
        this.mLoadStyle = loaderStyle;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoadStyle = LoaderStyle.BallClipRotatePulseIndicator;
        //        this.mLoadStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }

    /**
     * RestClient不是直接new出来的，对其构造器进行了处理使其可访问的范围尽可能小，
     * 只让它通过builder来构建自己。
     * 提供一种类set的方法链的方式来设置值
     * 最后的build()方法的时候会返回一个Student对象
     *
     * @return
     */
    public final RestClient build() {
        return new RestClient(
                mUrl, PARAMS, mDownloadDir, mExtension,
                mName, mIRequest, mISuccess, mIError,
                mIFailure, mBody, mfile, mContext, mLoadStyle);
    }
}
