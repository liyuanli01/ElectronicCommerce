package com.yuanli.latte.app;

import java.util.WeakHashMap;

/**
 * ElectronicCommerce
 * 配置器：配置文件的存储与获取
 *
 * @author liyuanli
 * @data 2018/3/7
 */

public class Configurator {

    // 这种存储的数据结构，在不使用的时候进行回收而且非常即时
    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    final WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    /**
     * 配置状态
     * .name()：枚举类的一个方法，以字符串String的形式输出
     */
    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
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
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    /**
     * 检查配置项有没有完成
     * 写类变量或方法变量时，尽量让变量的不可变性降低
     * 例：final
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            //没有配置完成时跑出一个运行时异常
            throw new RuntimeException("Configuration is not ready,call configurw");
        }
    }

    /**
     * 传入的是object，返回泛型T
     * @param key
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
