package com.demo.jingshouyhan.account.method;

import com.demo.jingshouyan.account.entity.AccountDO;
import com.demo.jingshouyhan.account.dao.AccountDao;
import com.github.jingshouyan.jrpc.base.bean.Token;
import com.github.jingshouyan.jrpc.server.method.Method;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jingshouyan
 * #date 2018/12/28 14:46
 */
@Component
@Slf4j
public class NewAccount implements Method<String, AccountDO> {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Hmily(confirmMethod = "confirm",cancelMethod = "cancel")
    public AccountDO action(Token token, String s) {
        log.info("action .. {}",s);
        AccountDO accountDO = new AccountDO();
        accountDO.setAccountId(s);
        return accountDO;
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
