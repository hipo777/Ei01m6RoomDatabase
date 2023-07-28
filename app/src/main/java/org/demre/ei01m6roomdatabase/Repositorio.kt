package org.demre.ei01m6roomdatabase

class Repositorio(private val tareaDao: TareaDao) {
    suspend fun insertTask(tarea: Tarea){
        tareaDao.insertarTarea(tarea)
    }
}