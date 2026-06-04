package com.veylik.notes.domain

import kotlinx.serialization.Serializable

sealed interface ContentItem {

    @Serializable
    data class Text(val content: String): ContentItem

    @Serializable
    data class Image(val url: String): ContentItem


}