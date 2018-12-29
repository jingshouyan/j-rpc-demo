package com.demo.jingshouyan.order.method;

import com.demo.jingshouyan.account.entity.AccountDO;
import com.github.jingshouyan.jrpc.base.bean.Rsp;
import com.github.jingshouyan.jrpc.base.bean.Token;
import com.github.jingshouyan.jrpc.client.JrpcClient;
import com.github.jingshouyan.jrpc.client.Request;
import com.github.jingshouyan.jrpc.server.method.Method;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jingshouyan
 * #date 2018/12/28 15:36
 */
@Component
@Slf4j
public class NewOrder implements Method<String, AccountDO> {
    @Autowired
    private JrpcClient client;

    @Override
    @Hmily(confirmMethod = "confirm",cancelMethod = "cancel")
    @Transactional
    public AccountDO action(Token token, String s) {
        log.info("action .. {}",s);
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("account")
                .setMethod("newAccount")
                .setParamObj(s)
                .send();
        return rsp.get(AccountDO.class);
    }

    public AccountDO confirm(Token token, String s) {
        log.info("confirm .. {}",s);
        AccountDO accountDO = new AccountDO();
        accountDO.setAccountId("confirm");
        return accountDO;
    }

    public AccountDO cancel(Token token, String s) {
        log.info("cancel .. {}",s);
        AccountDO accountDO = new AccountDO();
        accountDO.setAccountId("cancel");
        return accountDO;
    }
}
