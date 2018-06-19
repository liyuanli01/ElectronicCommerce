package com.yuanli.festec.example.generators;

import com.yuanli.latte.annotations.PayEntryGenerator;
import com.yuanli.latte.wechat.templates.WXPayEntryTemplate;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/14
 */

@PayEntryGenerator(
        packageName = "com.yuanli.festec.example",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
