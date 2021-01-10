package com.miteng.escache.dao

import com.miteng.escache.bean.Company
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

/**
 * Created by SunYiBo on 05/11/2018.
 * @author SunYiBo
 * @since 0.0.1-SNAPSHOT
 */
interface CompanyRepo : ElasticsearchRepository<Company, String>
