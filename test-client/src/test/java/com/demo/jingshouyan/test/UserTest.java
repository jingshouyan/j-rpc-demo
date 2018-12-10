package com.demo.jingshouyan.test;

import com.github.jingshouyan.jrpc.base.bean.Rsp;
import com.github.jingshouyan.jrpc.client.JrpcClient;
import com.github.jingshouyan.jrpc.client.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
