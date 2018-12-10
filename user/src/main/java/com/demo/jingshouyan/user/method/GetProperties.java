package com.demo.jingshouyan.user.method;

import com.demo.jingshouyan.user.config.UserProperties;
import com.github.jingshouyan.jrpc.base.bean.Empty;
import com.github.jingshouyan.jrpc.base.bean.Token;
import com.github.jingshouyan.jrpc.server.method.Method;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jingshouyan
 * 12/10/18 1:52 PM
 */
@Component
public class GetProperties implements Method<Empty,UserProperties> {

    @Resource
    private UserProperties userProperties;

    @Override
    public UserProperties action(Token token, Empty empty) {
        return userProperties;
    }
}
