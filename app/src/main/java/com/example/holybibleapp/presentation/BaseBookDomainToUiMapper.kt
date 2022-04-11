package com.example.holybibleapp.presentation

import com.example.holybibleapp.domain.BookDomainToUiMapper

class BaseBookDomainToUiMapper:BookDomainToUiMapper {
    override fun map(id: Int, name: String) = BookUi.Base(id, name)
}