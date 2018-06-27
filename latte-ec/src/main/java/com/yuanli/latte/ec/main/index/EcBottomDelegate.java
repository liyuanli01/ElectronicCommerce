package com.yuanli.latte.ec.main.index;

import android.graphics.Color;

import com.yuanli.latte.delegate.bottom.BaseBottomDeleegate;
import com.yuanli.latte.delegate.bottom.BottomItemDelegate;
import com.yuanli.latte.delegate.bottom.BottomTabBean;
import com.yuanli.latte.delegate.bottom.ItemBuilder;
import com.yuanli.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/27
 */

public class EcBottomDelegate extends BaseBottomDeleegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean,BottomItemDelegate> items=new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"),new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"),new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
