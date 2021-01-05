package com.miteng.escache.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.elasticsearch.rest")
public class Properties {

    private String uris;
}
