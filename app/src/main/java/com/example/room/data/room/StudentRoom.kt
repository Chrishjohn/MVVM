package com.example.room.data.repository.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class StudentRoom : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "product_name")
    var product_name: String? = null
    @ColumnInfo(name = "product_id")
    var product_id: String? = null
    @ColumnInfo(name = "seller_name")
    var seller_name: String? = null
    @ColumnInfo(name = "category_name")
    var category_name: String? = null
    @ColumnInfo(name = "email")
    var email: String? = null
    @ColumnInfo(name = "mobile")
    var mobile: String? = null


}