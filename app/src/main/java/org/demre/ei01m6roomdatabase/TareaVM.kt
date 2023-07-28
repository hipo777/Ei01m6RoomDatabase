package org.demre.ei01m6roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaVM(aplicacion: Application): AndroidViewModel(aplicacion) {
    private val repositorio : Repositorio
    init {
        repositorio = Repositorio(TareaBaseDatos.getDatabase(aplicacion).getTaskDao())
    }
    fun obtenerTareas(): LiveData<List<Tarea>> {
        return repositorio.getTareas()

    }


    fun insertarTareas(tarea: Tarea) = viewModelScope.launch{
        repositorio.insertTask(tarea)
    }
}