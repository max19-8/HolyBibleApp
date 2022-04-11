package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.cache.BookDb
import io.realm.Realm

interface BookDataToDbMapper: Abstract.Mapper {
    fun mapToDb(id: Int, name: String,realm: Realm):BookDb

    class Base():BookDataToDbMapper{
        override fun mapToDb(id: Int, name: String,realm: Realm):BookDb {
           val bookDb =  realm.createObject(BookDb::class.java, id)
           bookDb.name = name
            return bookDb
        }
    }
}