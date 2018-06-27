package com.yuanli.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/12
 */

public class DatabaseManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private DatabaseManager() {

    }

    public DatabaseManager init(Context context) {
        initDao(context);
        return this;
    }

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        //创建数据库：三个参数：参数1：上下文，参数2：库名，参数3：游标工厂
        //final DaoMaster.OpenHelper helper1 = new DaoMaster.DevOpenHelper(context, "fast_ec.db",null);
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        //这两个方法网上都有人在用，看了源码
        //getWritableDb()内部都是调用的getWritableDatabase()；
        //不过这个方法外面套了一层，用于返回标准的database，也没看懂，很简单的引用哪里就标准了？
        //final Database db = helper.getWritableDatabase();
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao() {
        mDao.queryBuilder().list();
        return mDao;
    }

}
