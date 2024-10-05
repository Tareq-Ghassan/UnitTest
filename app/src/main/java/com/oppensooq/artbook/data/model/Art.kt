package com.oppensooq.artbook.data.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class Art : RealmObject {
    var name: String = ""
    var artistName: String = ""
    var year: String = ""
    var imageUrl: String = ""

    @PrimaryKey
    var id: String = UUID.randomUUID().toString() // UUID as the primary key


    // Required zero-arg constructor for Realm
    constructor()

    // Convenience constructor for creating new instances
    constructor(name: String, artistName: String, year: String, imageUrl: String) : this() {
        this.name = name
        this.artistName = artistName
        this.year = year
        this.imageUrl = imageUrl
    }
}
