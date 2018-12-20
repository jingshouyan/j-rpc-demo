package com.demo.jingshouyan.user.method;
import com.demo.jingshouyan.user.constant.UserCode;
import com.github.jingshouyan.jrpc.base.exception.JException;
import com.google.common.collect.Lists;

import com.demo.jingshouyan.user.bean.UserBean;
import com.demo.jingshouyan.user.dao.UserDao;
import com.github.jingshouyan.jrpc.base.bean.Token;
import com.github.jingshouyan.jrpc.server.method.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class newUser implements Method<String, UserBean> {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserBean action(Token token, String nickname) {
        UserBean userBean = new UserBean();
        userBean.setName(nickname);
        userBean.setAge(0);
        userBean.setTags(Lists.newArrayList());
        userBean.setNickname(nickname);
        userBean.setCreatedAt(0L);
        userBean.setUpdatedAt(0L);
        userBean.setDeletedAt(0L);
        userDao.insert(userBean);
        if(userBean.getId() != null){
            throw new JException(UserCode.USER_TEST_CODE);
        }
        return userBean;
    }
}
