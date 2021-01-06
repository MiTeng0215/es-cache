package com.miteng.escache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableElasticsearchRepositories(basePackages = "com.miteng.escache.dao")
public class EsCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsCacheApplication.class, args);
    }

}
