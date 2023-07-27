package org.demre.ei01m6roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.demre.ei01m6roomdatabase.databinding.FragmentAgregarBinding

class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        recuperarTareas()
        return binding.root
    }
    private fun initListener() {
        binding.btnIngresar.setOnClickListener(){
            val texto =binding.etIngreso.text.toString()
            guardarTarea(texto)
        }
    }
    private fun guardarTarea(texto: String) {
        val guardarDao = TareaBaseDatos.getDatabase(requireContext() ).getTaskDao()
        val tarea = Tarea(texto)
        GlobalScope.launch { guardarDao.insertarTarea(tarea) }
    }
    private fun recuperarTareas(){
        val guardarDao = TareaBaseDatos.getDatabase(requireContext() ).getTaskDao()
        GlobalScope.launch {
            val tareas = guardarDao.getTareas()
            val tasksAsText = tareas.joinToString("\n") { it.nombre }
            binding.tvRecuperado.text = tasksAsText
        }
    }
}