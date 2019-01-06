package com.bazinga.capital.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yunshan
 * @date 2019/1/6
 */
public class OnDisconnectedEvent extends ApplicationEvent {

    private int loginType;

    public OnDisconnectedEvent(Object source, int loginType) {
        super(source);
        this.loginType = loginType;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}
