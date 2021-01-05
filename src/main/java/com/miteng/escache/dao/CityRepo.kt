package com.miteng.escache.dao

import com.miteng.escache.bean.City
import org.springframework.data.repository.CrudRepository

interface CityRepo : CrudRepository<City, String>