package com.demo.jingshouyan.user.bean;

import com.github.jingshouyan.jdbc.comm.annotaion.Column;
import com.github.jingshouyan.jdbc.comm.annotaion.Key;
import com.github.jingshouyan.jdbc.comm.bean.BaseBean;
import com.github.jingshouyan.jdbc.comm.bean.EncryptType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author jingshouyan
 * 12/7/18 2:15 PM
 */
@Getter
@Setter
@ToString
public class UserBean extends BaseBean {
    @Key
    private String id;

    @Column(encryptType = EncryptType.FLIED,encryptKey = "id")
    private String name;

    private Integer age;

    @Column(encryptType = EncryptType.FIXED,encryptKey = "abcd",json = true)
    private List<String> tags;

    @Column(value = "NICK_NAME_TT4")
    private String nickname;



    @Override
    public String idPrefix() {
        return "U";
    }
}