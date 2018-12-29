package com.demo.jingshouyan.account.entity;

import com.github.jingshouyan.jdbc.comm.annotaion.Column;
import com.github.jingshouyan.jdbc.comm.annotaion.Key;
import com.github.jingshouyan.jdbc.comm.bean.BaseBean;
import lombok.Data;

/**
 * @author jingshouyan
 * #date 2018/12/28 14:13
 */

@Data
public class AccountDO extends BaseBean {
    @Key@Column(length = 50)
    private String accountId;
}
