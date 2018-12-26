package com.demo.jingshouyan.test;

import com.github.jingshouyan.crud.bean.C;
import com.github.jingshouyan.crud.bean.R;
import com.github.jingshouyan.jdbc.comm.bean.Page;
import com.github.jingshouyan.jdbc.comm.util.ConditionUtil;
import com.github.jingshouyan.jrpc.base.bean.Rsp;
import com.github.jingshouyan.jrpc.base.util.json.JsonUtil;
import com.github.jingshouyan.jrpc.client.JrpcClient;
import com.github.jingshouyan.jrpc.client.Request;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author jingshouyan
 * 12/10/18 2:09 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApp.class)
public class UserTest {

    @Autowired
    private JrpcClient client;

    @Test
    public void getProperties(){
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("user")
                .setMethod("getProperties")
                .setParamJson("{}")
                .send();
        System.out.println(rsp.getResult());
    }

    @Test
    public void newUser(){
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("user")
                .setMethod("newUser")
                .setParamObj("张三")
                .send();
        System.out.println(rsp.getResult());
    }

    @Test
    public void single(){
        UserBean userBean = query(R.TYPE_SINGLE).get(UserBean.class);
        System.out.println(userBean);
    }

    @Test
    public void multiple(){
        List<UserBean> userBeans = query(R.TYPE_MULTIPLE).list(UserBean.class);
        System.out.println(userBeans);
    }

    @Test
    public void page(){
        Page<UserBean> page = query(R.TYPE_PAGE).get(Page.class,UserBean.class);
        System.out.println(page);
    }

    @Test
    public void list(){
        query(R.TYPE_LIST);
    }

    @Test
    public void limit(){
        query(R.TYPE_LIMIT);
    }

    public void update() {

    }

    @Test
    public void create2() throws Exception{
        List<UserBean> userBeans = Lists.newArrayList();
        UserBean u1 = new UserBean();
        u1.setName("u1");
        u1.setAge(10);
        u1.setTags(Lists.newArrayList("123","立刻解放的"));
        u1.setNickname("真的是");
        userBeans.add(u1);
        UserBean u2 = new UserBean();
        u2.setName("u2");
        u2.setAge(10);
        u2.setTags(Lists.newArrayList("123","立刻解放的"));
        u2.setNickname("真的是212");
        userBeans.add(u2);
        UserBean u3 = new UserBean();
        u3.setName("u1");
        u3.setAge(10);
        u3.setTags(Lists.newArrayList("123","立刻解放的"));
        u3.setNickname("真的是sds 上的");
        userBeans.add(u3);
        C c = new C();
        c.setBean("user");
        c.setType(C.TYPE_MULTIPLE);
        c.setData(JsonUtil.toJsonString(userBeans));
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("user")
                .setMethod("create")
                .setParamObj(c)
                .send();
    }

    @Test
    public void create() {

        Map<String,Object> m = Maps.newHashMap();
        m.put("name","这地方");
        m.put("name2","这地方");
        m.put("nickname","这地方222");
        C c = new C();
        c.setBean("user");
        c.setType(C.TYPE_SINGLE);
        c.setData(JsonUtil.toJsonString(m));
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("user")
                .setMethod("create")
                .setParamObj(c)
                .send();
        System.out.println(rsp);
    }

    private Rsp query(String type){
        R r = new R();
        r.setId("U19001");
        r.setIds(Lists.newArrayList("U10003","U10004"));
        r.setType(type);
        r.setPage(new Page());
        r.setConditions(ConditionUtil.newInstance()
//                .field("age").gt(20)
                .conditions());
        r.setBean("user");
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("user")
                .setMethod("retrieve")
                .setParamObj(r)
                .send();
        return rsp;
    }
}
