package com.example.holybibleapp.domain

import com.example.holybibleapp.data.BookDataToDomainMapper

class BaseBookDataToDomainMapper:BookDataToDomainMapper {
    override fun map(id: Int, name: String) = BookDomain.Base(id, name)
}