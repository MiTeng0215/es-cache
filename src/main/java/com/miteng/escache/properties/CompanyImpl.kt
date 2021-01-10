package com.miteng.escache.properties

import com.miteng.escache.bean.Company
import com.miteng.escache.dao.CompanyRepo
import org.elasticsearch.index.query.QueryBuilders
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.core.ScrolledPage
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.data.elasticsearch.core.query.SearchQuery
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
abstract class CompanyImpl : CompanyRepo{

    @Autowired
    private lateinit var elasticsearchRestTemplate: ElasticsearchRestTemplate


//    override fun findAllScroll(): MutableIterable<Company?> {
//        val searchQuery: SearchQuery = NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.matchAllQuery())
//                .withIndices("company")
//                .withTypes("company")
//                .withPageable(PageRequest.of(0, 100))//分页查询
//                .build()
//        var scroll: ScrolledPage<Company?> = elasticsearchRestTemplate.startScroll(2000, searchQuery, Company::class.java)
//        var scrollId = scroll.getScrollId()
//        val sampleEntities: MutableList<Company?> = ArrayList()
//        while (scroll.hasContent()) {
//            sampleEntities.addAll(scroll.content)
//            scrollId = scroll.getScrollId()
//            scroll = elasticsearchRestTemplate.continueScroll(scrollId, 2000, Company::class.java)
//        }
//        elasticsearchRestTemplate.clearScroll(scrollId)
//        return sampleEntities
//    }
}