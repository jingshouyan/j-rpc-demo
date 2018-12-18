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
import java.util.stream.IntStream;

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
                .setParam("{}")
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

    @Test
    public void create2() throws Exception{
        IntStream.range(0,100).parallel()
                .forEach(i -> create());
        Thread.sleep(10000);
        long start = System.currentTimeMillis();
        IntStream.range(0,1000).parallel()
                .forEach(i -> create());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
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
        r.setId("U10002");
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
