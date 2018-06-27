package com.yuanli.latte.app;

import android.app.Activity;

import com.blankj.utilcode.util.Utils;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * ElectronicCommerce
 * 配置器：配置文件的存储与获取
 *
 * @author liyuanli
 * @data 2018/3/7
 */

public class Configurator {

    // 这种存储的数据结构，在不使用的时候进行回收而且非常即时
    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();

    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    /**
     * 配置状态
     * .name()：枚举类的一个方法，以字符串String的形式输出
     */
    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
    }

    /**
     * 线程安全 懒汉模式
     *
     * @return
     */
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 静态内部类
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /***************线程安全 懒汉模式  end   ********************/

    public final void configure() {
        initIcons();
        Logger.addLogAdapter(new AndroidLogAdapter());
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
        Utils.init(Latte.getApplicationContext());
    }


    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    /**
     * 检查配置项有没有完成
     * 写类变量或方法变量时，尽量让变量的不可变性降低
     * 例：final
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            //没有配置完成时跑出一个运行时异常
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     * 传入的是object，返回泛型T
     *
     * @param key
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LATTE_CONFIGS.get(key);
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    public final Configurator withWeChatAppId(String appId) {
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
        return this;
    }

    public final Configurator withWeChatAppSecret(String appSecret) {
        LATTE_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    /**
     * 微信回调时候用
     *
     * @param activity
     * @return
     */
    public final Configurator withActivity(Activity activity) {
        LATTE_CONFIGS.put(ConfigKeys.ACTIVITY, activity);
        return this;
    }

}
