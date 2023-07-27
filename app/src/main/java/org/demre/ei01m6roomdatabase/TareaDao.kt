package org.demre.ei01m6roomdatabase

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

}