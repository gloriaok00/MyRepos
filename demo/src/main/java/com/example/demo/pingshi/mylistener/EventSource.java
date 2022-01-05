package com.example.demo.pingshi.mylistener;

/*
 * 事件源：事件发生的地点
 */
public class EventSource {
    private IEventListener mEventListener;

    // 注册监听器
    public void setEventListener(IEventListener arg) {
        mEventListener = arg;
    }

    // 触发事件
    public void EventHappened() {
        mEventListener.onclickButton();
    }

}
