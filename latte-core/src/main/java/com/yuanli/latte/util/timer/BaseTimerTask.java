package com.yuanli.latte.util.timer;

import java.util.TimerTask;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/5
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerLister = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerLister = timerListener;
    }

    @Override
    public void run() {
        if (mITimerLister != null) {
            mITimerLister.onTimer();
        }
    }
}
