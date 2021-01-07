package com.miteng.escache.bean

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.io.Serializable

/**
 * Created by SunYiBo on 16/10/2018.
 * @author SunYiBo
 * @since 0.0.1-SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class DocumentTagDetail(


    @Field(type = FieldType.Keyword)
    val id: String? = null,


    @Field(type = FieldType.Integer)
    val caseCauseId: Int? = null,


    @Field(type = FieldType.Keyword)
    val locateParagraph: String? = null,


    @Field(type = FieldType.Integer)
    val proceeding: Int? = null,


    @Field(type = FieldType.Text)
    val includeKeywords: String? = null,


    @Field(type = FieldType.Text)
    val excludeKeywords: String? = null,


    @Field(type = FieldType.Text)
    val regrex: String? = null,


    @Field(type = FieldType.Text)
    val backups: List<String>? = null,


    @Field(type = FieldType.Integer)
    val sort: Int? = null,


    @Field(type = FieldType.Double)
    val importance: Double? = null,


    val isImportant: Boolean? = null,


    @Field(type = FieldType.Integer)
    val countTagInPara: Long? = null,

    @Field(type = FieldType.Integer)
    val countLocateInPara: Long? = null,

    @Field(type = FieldType.Integer)
    val countLocateInCause: Long? = null,

    @Field(type = FieldType.Integer)
    val countCaseCauseInCause: Long? = null,


    @Field(type = FieldType.Boolean)
    val isAutoTag: Boolean? = null,


    @Field(type = FieldType.Boolean)
    val isTaged: Boolean? = null,


    @Field(type = FieldType.Boolean)
    val isMultiSelect: Boolean? = null,


    @Field(type = FieldType.Boolean)
    val isDelete: Boolean? = null,


    @Field(type = FieldType.Boolean)
    val highlight: Boolean? = null
) : Serializable
