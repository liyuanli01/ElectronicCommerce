package com.yuanli.festec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yuanli.latte.app.Latte;
import com.yuanli.latte.ec.database.DatabaseManager;
import com.yuanli.latte.ec.icon.FontEcModule;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/3/7
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //微信：这里是传值的地方，真正的调用在ec里
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://192.168.1.167/")
                .withWeChatAppId("wx1cde1971164ae0a6")
                .withWeChatAppSecret("dfc4d6157daa2620f8faac76fc4b0fb1")
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
    }

    private void initStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }

}
