package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Mapable<Book,BookCacheMapper> {
    @PrimaryKey
    var id :Int = -1
    var name:String = ""

    override fun map(mapper: BookCacheMapper) = Book(id, name)
    }