package com.example.holybibleapp.presentation

import com.example.holybibleapp.R
import com.example.holybibleapp.domain.BookDomainToUiMapper
import com.example.holybibleapp.domain.TestamentType

class BaseBookDomainToUiMapper(private val resourceProvider: ResourceProvider):BookDomainToUiMapper {
    override fun map(id: Int, name: String) = when (id) {
        TestamentType.NEW.getId() -> BookUi.Testament(
            id,
            resourceProvider.getString(R.string.new_testament)
        )
        TestamentType.OLD.getId() -> BookUi.Testament(
            id,
            resourceProvider.getString(R.string.old_testament)
        )
        else -> BookUi.Base(id, name)
    }
}

