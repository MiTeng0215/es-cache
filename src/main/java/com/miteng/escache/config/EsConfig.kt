package com.miteng.escache.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.support.DefaultConversionService
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper
import org.springframework.data.elasticsearch.core.EntityMapper
import org.springframework.http.HttpHeaders


@Configuration
class EsConfig : AbstractElasticsearchConfiguration() {

//    @Value("\${spring.elasticsearch.rest.uris}")
//    private val hostAndPort: String? = null
//    @Value("\${spring.elasticsearch.jest.username}")
//    private val username: String? = null
//    @Value("\${spring.elasticsearch.jest.password}")
//    private val password: String? = null

//    @Bean
//    fun restClient(): RestHighLevelClient? {
//        val credentialsProvider: CredentialsProvider = BasicCredentialsProvider()
//        credentialsProvider.setCredentials(AuthScope.ANY, UsernamePasswordCredentials("casefake", "aegis2018"))
//        return RestHighLevelClient(
//                RestClient.builder(HttpHost("es1.http.aegis-info.com", 80))
//                        .setRequestConfigCallback { requestConfigBuilder ->
//                            // 该方法接收一个RequestConfig.Builder对象，对该对象进行修改后然后返回。
//                            requestConfigBuilder.setConnectTimeout(5000 * 1000) // 连接超时（默认为1秒）
//                                    .setSocketTimeout(6000 * 1000) // 套接字超时（默认为30秒）//更改客户端的超时限制默认30秒现在改为100*1000分钟
//                        }
//                        .setMaxRetryTimeoutMillis(1000000)
//                        .setHttpClientConfigCallback { httpClientBuilder ->
//                            httpClientBuilder.disableAuthCaching()
//                            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
//                        }
//        )
//    }

    @Bean
    fun client(): RestHighLevelClient  {
        val clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build()
        return RestClients.create(clientConfiguration).rest()
    }

    override fun elasticsearchClient(): RestHighLevelClient {
        return client()
    }

    @Bean
    override fun entityMapper(): EntityMapper? {
        val entityMapper = ElasticsearchEntityMapper(elasticsearchMappingContext(),
                DefaultConversionService())
        entityMapper.setConversions(elasticsearchCustomConversions())
        return entityMapper
    }

}