package com.yuanli.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * OpenHelper的父类为SQLiteOpenHelper，SQLiteOpenHelper主要用来创建数据库。
 * 该类的构造器中，调用Context中的方法创建并打开一个指定名称的数据库对象。
 * 如果打开的数据库版本号与当前的版本号不同则会调用onUpgrade()方法，删除数据库中所有表重新初始化调用onCreate()，在父类中完成表的创建。
 *
 *
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
