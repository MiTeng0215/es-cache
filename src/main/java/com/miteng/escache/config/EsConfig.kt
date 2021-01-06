package com.miteng.escache.config

import org.apache.http.HttpHost
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.CredentialsProvider
import org.apache.http.impl.client.BasicCredentialsProvider
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.RestClientFactoryBean
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate


@Configuration
class EsConfig {

//    @Value("\${spring.elasticsearch.rest.uris}")
//    private val hostAndPort: String? = null
//    @Value("\${spring.elasticsearch.jest.username}")
//    private val username: String? = null
//    @Value("\${spring.elasticsearch.jest.password}")
//    private val password: String? = null

    @Bean
    fun restClient(): RestHighLevelClient? {
        val credentialsProvider: CredentialsProvider = BasicCredentialsProvider()
        credentialsProvider.setCredentials(AuthScope.ANY, UsernamePasswordCredentials("casefake", "aegis2018"))
        return RestHighLevelClient(
                RestClient.builder(HttpHost("es1.http.aegis-info.com", 80))
                        .setRequestConfigCallback { requestConfigBuilder ->
                            // 该方法接收一个RequestConfig.Builder对象，对该对象进行修改后然后返回。
                            requestConfigBuilder.setConnectTimeout(5000 * 1000) // 连接超时（默认为1秒）
                                    .setSocketTimeout(6000 * 1000) // 套接字超时（默认为30秒）//更改客户端的超时限制默认30秒现在改为100*1000分钟
                        }
                        .setMaxRetryTimeoutMillis(1000000)
                        .setHttpClientConfigCallback { httpClientBuilder ->
                            httpClientBuilder.disableAuthCaching()
                            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                        }
        )
    }
}