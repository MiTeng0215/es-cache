package com.miteng.escache.config

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.support.DefaultConversionService
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper
import org.springframework.data.elasticsearch.core.EntityMapper
import java.time.Duration


@Configuration
class EsConfig : AbstractElasticsearchConfiguration() {

    @Value("\${spring.elasticsearch.rest.uris}")
    private val hostAndPort: String? = null
    @Value("\${spring.elasticsearch.rest.username}")
    private val username: String? = null
    @Value("\${spring.elasticsearch.rest.password}")
    private val password: String? = null


    override fun elasticsearchClient(): RestHighLevelClient {
        val clientConfiguration: ClientConfiguration = ClientConfiguration.builder()
                .connectedTo(hostAndPort)
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                .withBasicAuth(username, password)
                .build()
        return RestClients.create(clientConfiguration).rest()
    }

    @Bean
    override fun entityMapper(): EntityMapper? {
        val entityMapper = ElasticsearchEntityMapper(elasticsearchMappingContext(),
                DefaultConversionService())
        entityMapper.setConversions(elasticsearchCustomConversions())
        return entityMapper
    }

}