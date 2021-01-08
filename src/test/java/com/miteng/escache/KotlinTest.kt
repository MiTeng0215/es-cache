package com.miteng.escache

import com.miteng.escache.bean.City
import com.miteng.escache.dao.CityRepo
import com.miteng.escache.dao.DocumentTagRepo
import com.miteng.escache.properties.EsProperties
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.index.query.QueryBuilders.matchAllQuery
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import org.springframework.data.elasticsearch.core.ScrolledPage
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.data.elasticsearch.core.query.SearchQuery
import org.springframework.test.context.junit4.SpringRunner
import java.util.*


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

    @Autowired
    private lateinit var elasticsearchOperations: ElasticsearchOperations

    @Autowired
    private lateinit var elasticsearchTemplate: ElasticsearchTemplate

    @Test
    fun ttt() {

        val searchQuery: SearchQuery = NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withIndices("city")
                .withTypes("_doc")
                .withFields("message")
                .withPageable(PageRequest.of(0, 10))
                .build()

        var scroll: ScrolledPage<City?> = elasticsearchTemplate.startScroll(1000, searchQuery, City::class.java)
        val scrollId = scroll.scrollId
        val cityEntities: MutableList<City> = ArrayList()
        while (scroll.hasContent()) {

//            cityEntities.addAll(scroll.content)
        }


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