package com.yuanli.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * ElectronicCommerce
 * 对外工具类，内部方法全是static静态方法
 * 把全局的一些信息存到map里，包括application
 * @author liyuanli
 * @data 2018/3/7
 */

public class Latte {

    //把对象的引用转入到了配置项目
    public static Configurator init(Context context){
        getConfigutations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigutations(){
        return Configurator.getInstance().getLatteConfigs();
    }

}
