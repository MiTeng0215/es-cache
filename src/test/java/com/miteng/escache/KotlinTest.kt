package com.miteng.escache

import com.miteng.escache.bean.City
import com.miteng.escache.bean.Company
import com.miteng.escache.dao.*
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
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
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
//
    @Autowired
    private lateinit var elasticsearchOperations: ElasticsearchOperations

    @Autowired
    private lateinit var elasticsearchRestTemplate: ElasticsearchRestTemplate


    @Test
    fun ttt() {

        val searchQuery: SearchQuery = NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withIndices("city")
                .withTypes("_doc")
                .withFields("message")
                .withPageable(PageRequest.of(0, 10))
                .build()



        var scroll: ScrolledPage<City?> = elasticsearchOperations.startScroll(1000, searchQuery, City::class.java)
        val scrollId = scroll.scrollId
        val cityEntities: MutableList<City> = ArrayList()
        while (scroll.hasContent()) {

//            cityEntities.addAll(scroll.content)
        }


    }

    @Test
    fun tttttt() {
        val searchQuery: SearchQuery = NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withIndices("company")
                .withTypes("company")
                .withPageable(PageRequest.of(0, 10))//分页查询
                .build()


        //先查一页数据
        var scroll: ScrolledPage<Company?> = elasticsearchOperations.startScroll(1000, searchQuery, Company::class.java)
        var scrollId = scroll.getScrollId()//获取回滚id
        val sampleEntities: MutableList<Company?> = ArrayList()
        while (scroll.hasContent()) {//如果有数据,循环继续查询剩余数据
            sampleEntities.addAll(scroll.content)
            scrollId = scroll.getScrollId()
            //1s内没有继续循环id就过期
            scroll = elasticsearchOperations.continueScroll(scrollId, 1000, Company::class.java)//scrollTime是scrollId过去时间
        }
        elasticsearchOperations.clearScroll<Company>(scrollId)
        println(sampleEntities.size)
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

    @Autowired
    private lateinit var companyRepo: CompanyRepo

    @Autowired
    private lateinit var scrollFindServiceImpl: ScrollFindServiceImpl

    @Test
    fun test2() {
        var scrollFindAll = scrollFindServiceImpl.scrollFindAll()
    }

}