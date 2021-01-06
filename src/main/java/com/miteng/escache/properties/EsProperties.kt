package com.miteng.escache.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("spring.data.elasticsearch")
class EsProperties {
    lateinit var addresses: List<String>

    lateinit var password: String

    lateinit var username: String

    var connectTimeout: Int = 5

    var socketTimeout: Int = 3
}