package com.yuanli.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.yuanli.latte.app.Latte;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/5/28
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
