package com.yuanli.latte.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * ElectronicCommerce
 * 对外工具类，内部方法全是static静态方法
 * 把全局的一些信息存到map里，包括application
 *
 * @author liyuanli
 * @data 2018/3/7
 */

public class Latte {

    //把对象的引用转入到了配置项目  LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<Object, Object> getConfigutations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }

    public static void test() {
    }

}
