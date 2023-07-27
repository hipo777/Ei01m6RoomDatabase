package org.demre.ei01m6roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")//nombre de la tabla
data class Tarea (val nombre: String ){
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}