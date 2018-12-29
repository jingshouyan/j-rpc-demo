package com.demo.jingshouyan.test;

import com.github.jingshouyan.jrpc.base.bean.Rsp;
import com.github.jingshouyan.jrpc.client.JrpcClient;
import com.github.jingshouyan.jrpc.client.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author jingshouyan
 * #date 2018/12/28 15:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApp.class)
public class OrderTest {
    @Autowired
    private JrpcClient client;

    @Test
    public void newOrder(){
        String s = UUID.randomUUID().toString();
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("order")
                .setMethod("newOrder")
                .setParamObj(s)
                .send();
        System.out.println(rsp);
    }

    @Test
    public void newAccount(){
        String s = UUID.randomUUID().toString();
        Rsp rsp = Request.newInstance()
                .setClient(client)
                .setServer("account")
                .setMethod("newAccount")
                .setParamObj(s)
                .send();
        System.out.println(rsp);
    }
}
