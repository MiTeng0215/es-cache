package com.miteng.escache.bean

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.*
import java.io.Serializable

/**
 * 城市
 * Created by SunYiBo on 16/10/2018.
 * @author SunYiBo
 * @since 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "city", type = "_doc", createIndex = false)
data class City(

    @Field(type = FieldType.Integer)
    val areaCode: Int? = null,

    @Id
    @Field(type = FieldType.Integer)
    val id: Int? = null,

    @MultiField(
        mainField = Field(type = FieldType.Text, analyzer = "ik", searchAnalyzer = "ik"),
        otherFields = [
          InnerField(suffix = "pinyin_first_letter", searchAnalyzer = "pinyin_first_letter", type = FieldType.Text, analyzer = "pinyin_first_letter"),
          InnerField(suffix = "pinyin", searchAnalyzer = "pinyin", type = FieldType.Text, analyzer = "pinyin"),
          InnerField(suffix = "ik", searchAnalyzer = "ik_max_word", type = FieldType.Text, analyzer = "ik_max_word"),
          InnerField(suffix = "text", type = FieldType.Keyword)])
    val name: String? = null,

    @Field(type = FieldType.Object)
    val province: Province? = null,

    @Field(type = FieldType.Integer)
    val provinceId: Int? = null
) : Serializable
