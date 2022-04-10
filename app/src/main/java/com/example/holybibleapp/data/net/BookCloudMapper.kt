package com.example.holybibleapp.data.net

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book

interface BookCloudMapper : Abstract.Mapper {

    fun map(id: Int, name: String): Book

    class Base : BookCloudMapper {
        override fun map(id: Int, name: String) = Book(id, name)
    }

}