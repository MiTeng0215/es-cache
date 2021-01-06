package com.miteng.escache.dao

import com.miteng.escache.bean.City
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.repository.CrudRepository
//
interface CityRepo : ElasticsearchRepository<City, String>