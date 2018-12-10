package com.demo.jingshouyan.user.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jingshouyan
 * 12/10/18 1:51 PM
 */

@ConfigurationProperties(prefix = "demo.user")
@Getter@Setter@ToString
public class UserProperties {
    private String name;
    private String nickname;
}
