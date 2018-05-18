package com.yuanli.latte.app;

/**
 * ElectronicCommerce
 * 枚举类：唯一的单例，只能被初始化一次
 * 线程安全的懒汉模式
 *
 * @author liyuanli
 * @data 2018/3/7
 */

public enum ConfigType {
    API_HOST,
    APPLICATION_CONTEXT,
    CONFIG_READY,
    ICON
}
