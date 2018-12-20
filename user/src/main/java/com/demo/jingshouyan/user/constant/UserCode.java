package com.demo.jingshouyan.user.constant;

import com.github.jingshouyan.jrpc.base.code.Code;
import org.springframework.stereotype.Component;

@Component
public class UserCode {

    public static final int USER_TEST_CODE = 123;

    static {
        Code.regCode(USER_TEST_CODE,"用户测试错误码");
    }
}
