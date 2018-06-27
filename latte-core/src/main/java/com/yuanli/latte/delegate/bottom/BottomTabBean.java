package com.yuanli.latte.delegate.bottom;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/26
 */

public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;


    public BottomTabBean(CharSequence icon, CharSequence title) {
        ICON = icon;
        TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
