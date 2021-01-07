package com.miteng.escache.bean

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.io.Serializable
import java.util.*

/**
 * Created by SunYiBo on 16/10/2018.
 * @author SunYiBo
 * @since 0.0.1SNAPSHOT
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "document_tag", type = "_doc", createIndex = false)
data class DocumentTag(

    @Field(type = FieldType.Integer)
    val appType: List<Int>? = null,

    @Field(type = FieldType.Integer)
    val caseCauseIds: Set<Int>? = null,

    @Field(type = FieldType.Text)
    val copyWrite: String? = null,


    @Field(type = FieldType.Text)
    val description: String? = null,

    @Field(type = FieldType.Nested)
    val details: List<DocumentTagDetail>? = null,


    @Field(type = FieldType.Integer)
    val divideParty: Int? = null,


    @Field(type = FieldType.Integer)
    val documentType: List<Int>? = null,


    @Field(type = FieldType.Integer)
    val factType: Int? = null,


    @Field(type = FieldType.Integer)
    val featureType: Int? = null,


    @Field(type = FieldType.Integer)
    val grade: Int? = null,


    @Field(type = FieldType.Boolean)
    val hasChild: Boolean? = null,


    @Id
    @Field(type = FieldType.Keyword)
    val id: String? = null,


    @Field(type = FieldType.Integer)
    val isAskLink: Int? = null,


    @Field(type = FieldType.Boolean)
    val isDelete: Boolean? = null,


    @Field(type = FieldType.Integer)
    val isDigitalFeature: Int? = null,


    @Field(type = FieldType.Integer)
    val isDistinguishParty: Int? = null,


    @Field(type = FieldType.Integer)
    val isGradeFeature: Int? = null,


    @Field(type = FieldType.Integer)
    val isPracticeTag: Int? = null,


    @Field(type = FieldType.Boolean)
    val isSelectable: Boolean? = null,


    @Field(type = FieldType.Integer)
    val isSensitiveTag: Int? = null,

    @Field(type = FieldType.Date)
    val lastUpdateTime: Date? = null,

    @Field(type = FieldType.Text)
    val nickName: String? = null,

    @Field(type = FieldType.Keyword)
    val operators: List<String>? = null,

    @Field(type = FieldType.Keyword)
    val parent: String? = null,

    @Field(type = FieldType.Integer)
    val plotId: Int? = null,

    @Field(type = FieldType.Integer)
    val relevance: Set<Int>? = null,

    @Field(type = FieldType.Integer)
    val relevanceSkip: Int? = null,

    @Field(type = FieldType.Keyword)
    val relevanceTags: Set<String>? = null,

    @Field(type = FieldType.Integer)
    val skip: Int? = null,

    @Field(type = FieldType.Integer)
    val tagType: Int? = null,


    @Field(type = FieldType.Keyword)
    val topParent: String? = null,


    @Field(type = FieldType.Integer)
    val type: Int? = null,

    @Field(type = FieldType.Keyword)
    val unit: String? = null,

    @Field(type = FieldType.Text)
    val zhName: String? = null
) : Serializable
