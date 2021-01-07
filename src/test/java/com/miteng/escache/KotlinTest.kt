package com.miteng.escache

import com.miteng.escache.dao.CityRepo
import com.miteng.escache.dao.DocumentTagRepo
import com.miteng.escache.properties.EsProperties
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class KotlinTest {

    @Autowired
    private lateinit var cityRepo: CityRepo

    @Autowired
    private lateinit var documentTagRepo: DocumentTagRepo

    @Test
    fun unitTestingWorks() {
        println(documentTagRepo.findAll().toList().size)
    }

    @Test
    fun tt() {
        println(cityRepo.findAll().toList().size)
    }
//
    @Autowired
    private lateinit var restHighLevelClient:RestHighLevelClient

    @Test
    fun test() {
        val index = CreateIndexRequest("first")
        val create = restHighLevelClient.indices().create(index, RequestOptions.DEFAULT)
        println(create)
    }

    @Autowired
    private lateinit var esProperties: EsProperties

    @Test
    fun test2() {
        println(esProperties.password)
    }

}