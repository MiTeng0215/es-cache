package com.miteng.escache.bean

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.*
import java.io.Serializable
import java.util.*

/**
 * Created by SunYiBo on 05/11/2018.
 * @author SunYiBo
 * @since 0.0.1-SNAPSHOT
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(indexName = "company", type = "company", createIndex = false)
data class Company(

    @Field(type = FieldType.Text)
    val address: String? = null,

    @Field(type = FieldType.Text)
    val businessArea: String? = null,


    @Field(type = FieldType.Nested)
    val catalogapplies: List<CompanyCatalogapply>? = null,

    @Field(type = FieldType.Long)
    val createTime: Date? = null,

    @Field(type = FieldType.Long)
    val endTime: Date? = null,

    @Id
    @Field(type = FieldType.Keyword)
    val id: String? = null,

    @Field(type = FieldType.Long)
    val lastUpdateTime: Date? = null,

    @Field(type = FieldType.Text)
    val legalRepresentative: String? = null,

    @Field(type = FieldType.Keyword)
    val logoLink: String? = null,

    @MultiField(
        mainField = Field(type = FieldType.Text, analyzer = "ik", searchAnalyzer = "ik"),
        otherFields = [
          InnerField(suffix = "pinyin_first_letter", searchAnalyzer = "pinyin_first_letter", type = FieldType.Text, analyzer = "pinyin_first_letter"),
          InnerField(suffix = "pinyin", searchAnalyzer = "pinyin", type = FieldType.Text, analyzer = "pinyin"),
          InnerField(suffix = "ik", searchAnalyzer = "ik_max_word", type = FieldType.Text, analyzer = "ik_max_word"),
          InnerField(suffix = "text", type = FieldType.Keyword)])

    val name: String? = null,

    @Field(type = FieldType.Long)
    val passTime: Date? = null,

    @Field(type = FieldType.Integer)
    val provinceId: Int? = null,

    @Field(type = FieldType.Nested)
    val punishments: List<CompanyPunishment>? = null,

    @Field(type = FieldType.Double)
    val registeredCapital: Double? = null,

    @Field(type = FieldType.Text)
    val registrationAuthority: String? = null,

    @Field(type = FieldType.Long)
    val searchCount: Int? = null,

    @Field(type = FieldType.Long)
    val search_count: Int? = null,

    @Field(type = FieldType.Text)
    val shareholder: String? = null,

    @Field(type = FieldType.Long)
    val startTime: Date? = null,

    @Field(type = FieldType.Keyword)
    val type: String? = null,

    @Field(type = FieldType.Keyword)
    val url: String? = null,


    @Field(type = FieldType.Keyword)
    val workState: String? = null
) : Serializable
