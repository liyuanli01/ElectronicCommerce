package com.yuanli.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuanli.latte.app.AccountManager;
import com.yuanli.latte.ec.database.DatabaseManager;
import com.yuanli.latte.ec.database.UserProfile;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/12
 */

public class SignHandler {

    public static void onSignIn(String response, ISignListener iSignListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("UserID");
        final String name = profileJson.getString("UserName");
        final String avatar = profileJson.getString("Telephone");
        final String gender = profileJson.getString("Sex");
        final String address = profileJson.getString("PositionName");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insertOrReplace(profile);

        //已经登录
        AccountManager.setSignState(true);
        iSignListener.onSignInSuccess();
    }

}
