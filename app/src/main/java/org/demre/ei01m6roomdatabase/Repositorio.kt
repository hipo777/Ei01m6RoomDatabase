package org.demre.ei01m6roomdatabase

import androidx.lifecycle.LiveData

class Repositorio(private val tareaDao: TareaDao) {
    suspend fun insertTask(tarea: Tarea){
        tareaDao.insertarTarea(tarea)//Insertar tarea
    }
    fun getTareas():LiveData<List<Tarea>>{
        return tareaDao.getTareas()//obtener tarea
    }
}