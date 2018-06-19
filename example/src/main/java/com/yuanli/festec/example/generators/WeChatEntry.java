package com.yuanli.festec.example.generators;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/14
 */

import com.yuanli.latte.annotations.EntryGenerator;
import com.yuanli.latte.wechat.templates.WXEntryTemplate;

@EntryGenerator(
        packageName = "com.yuanli.festec.example",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
