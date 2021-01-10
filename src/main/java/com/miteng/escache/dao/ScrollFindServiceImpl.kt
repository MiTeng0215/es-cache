package com.miteng.escache.dao

import com.miteng.escache.bean.Company
import com.miteng.escache.dao.ScrollFindService
import org.elasticsearch.index.query.QueryBuilders
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.data.domain.PageRequest
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.data.elasticsearch.core.ScrolledPage
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.data.elasticsearch.core.query.SearchQuery
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class ScrollFindServiceImpl {

    @Autowired
    private lateinit var elasticsearchOperations: ElasticsearchOperations

    fun scrollFindAll() {
        val searchQuery: SearchQuery = NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
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
        println(sampleEntities.size)
        elasticsearchOperations.clearScroll<Company>(scrollId)
    }
}