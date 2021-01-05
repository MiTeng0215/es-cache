package com.miteng.escache

import com.miteng.escache.dao.CityRepo
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

    @Test
    fun unitTestingWorks() {
        println(cityRepo.findAll().toList())
    }
}