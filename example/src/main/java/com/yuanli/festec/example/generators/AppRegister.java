package com.yuanli.festec.example.generators;

import com.yuanli.latte.annotations.AppRegisterGenerator;
import com.yuanli.latte.wechat.templates.AppRegisterTemplate;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/14
 */

@AppRegisterGenerator(
        packageName = "com.yuanli.festec.example",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {

}
