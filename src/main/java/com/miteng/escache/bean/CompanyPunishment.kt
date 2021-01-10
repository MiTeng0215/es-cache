package com.miteng.escache.bean

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.io.Serializable
import java.util.*

/**
 * Created by SunYiBo on 05/11/2018.
 * @author SunYiBo
 * @since 0.0.1-SNAPSHOT
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class CompanyPunishment(

    @Field(type = FieldType.Keyword)
    val compId: String? = null,

    @Field(type = FieldType.Text)
    val content: String? = null,

    @Field(type = FieldType.Keyword)
    val docNumber: String? = null,


    @Id
    @Field(type = FieldType.Keyword)
    val id: String? = null,


    @Field(type = FieldType.Long)
    val time: Date? = null,


    @Field(type = FieldType.Keyword)
    val type: String? = null,


    @Field(type = FieldType.Text)
    val unit: String? = null,


    @Field(type = FieldType.Integer)
    val xh: Int? = null
) : Serializable
