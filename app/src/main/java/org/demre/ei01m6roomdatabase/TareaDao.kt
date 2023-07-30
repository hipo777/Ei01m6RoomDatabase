package org.demre.ei01m6roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    //recibir datos
    @Query("select * from user_table order by id ASC")
    fun getTareas():LiveData<List<Tarea>>
    //Con esto tenemos acceso a la información

}