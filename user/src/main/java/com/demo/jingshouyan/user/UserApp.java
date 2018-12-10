package com.demo.jingshouyan.user;

import com.demo.jingshouyan.user.config.UserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jingshouyan
 * 12/7/18 2:10 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(UserProperties.class)
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);
    }
}
