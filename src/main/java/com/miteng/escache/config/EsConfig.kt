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
import org.springframework.core.convert.support.DefaultConversionService
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper
import org.springframework.data.elasticsearch.core.EntityMapper


@Configuration
class EsConfig : AbstractElasticsearchConfiguration() {

//    @Value("\${spring.elasticsearch.rest.uris}")
//    private val hostAndPort: String? = null
//    @Value("\${spring.elasticsearch.jest.username}")
//    private val username: String? = null
//    @Value("\${spring.elasticsearch.jest.password}")
//    private val password: String? = null

//    @Bean
//    fun client(): RestHighLevelClient  {
//        val clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("es1.http.aegis-info.com:80", "es2.http.aegis-info.com:80", "es3.http.aegis-info.com:80")
//                .withConnectTimeout(Duration.ofSeconds(5))
//                .withSocketTimeout(Duration.ofSeconds(3))
//                .withBasicAuth("casefake", "aegis2018")
//                .build()
//        var host1 = HttpHost("es1.http.aegis-info.com", 80);
//        val builder: RestClientBuilder = RestClient.builder(host1)
//
//        return RestClients.create(clientConfiguration).rest()
//    }

    override fun elasticsearchClient(): RestHighLevelClient {
        val credentialsProvider: CredentialsProvider = BasicCredentialsProvider()
        credentialsProvider.setCredentials(AuthScope.ANY, UsernamePasswordCredentials("casefake", "aegis2018"))
        val h1 = HttpHost("es1.http.aegis-info.com", 80)
//        val h2 = HttpHost("es2.http.aegis-info.com", 80)
//        val h3 = HttpHost("es3.http.aegis-info.com", 80)
        return RestHighLevelClient(
                RestClient.builder(h1)
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