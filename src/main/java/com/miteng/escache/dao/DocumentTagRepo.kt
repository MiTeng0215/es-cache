package com.miteng.escache.dao

import com.miteng.escache.bean.DocumentTag
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

/**
 * Created by SunYiBo on 17/10/2018.
 * @author SunYiBo
 * @since 0.0.1-SNAPSHOT
 */
interface DocumentTagRepo : ElasticsearchRepository<DocumentTag, String> {
}
