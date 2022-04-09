package com.example.holybibleapp.data.net

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.google.gson.annotations.SerializedName


/* {"id": 1,"name": "Genesis","testament": "OT","genre": {"id": 1,"name": "Law"}} */

data class BookCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String
) : Abstract.Object<Book, BookCloudMapper>() {
    override fun map(mapper: BookCloudMapper): Book = mapper.map(id, name)
}
