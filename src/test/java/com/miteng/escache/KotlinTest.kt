package com.miteng.escache

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class KotlinTest {

//    @Autowired
//    private lateinit var cityRepo: CityRepo
//
//    @Test
//    fun unitTestingWorks() {
//        println(cityRepo.findAll().toList().size)
//    }
//
//      @Qualifier("restClient")
//      @Autowired
//      private lateinit var restHighLevelClient:RestHighLevelClient

//    @Test
//    fun test() {
//        val index = CreateIndexRequest("first")
//        val create = restHighLevelClient.indices().create(index, RequestOptions.DEFAULT)
//        println(create)
//    }

}