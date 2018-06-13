package com.yuanli.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/12
 */

public class ReleaseOpenHelper extends DaoMaster.OpenHelper {

    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
