package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.BookData

import com.example.holybibleapp.data.ToBookMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Object<BookData, ToBookMapper> {
    @PrimaryKey
    var id :Int = -1
    var name:String = ""
    var testament:String =""

    override fun map(mapper: ToBookMapper) = BookData(id, name,testament)
    }