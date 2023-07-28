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
    lateinit var repositorio: Repositorio
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initRepositorio()
        initListener()
        recuperarTareas()
        return binding.root
    }

    private fun initRepositorio() {
        repositorio = Repositorio(TareaBaseDatos.getDatabase(requireContext() ).getTaskDao())
    }

    private fun initListener() {
        binding.btnIngresar.setOnClickListener(){
            val texto =binding.etIngreso.text.toString()
            guardarTarea(texto)
        }
    }
    private fun guardarTarea(texto: String) {

        val tarea = Tarea(texto)
        GlobalScope.launch { repositorio.insertTask(tarea) }
    }
    private fun recuperarTareas(){

        repositorio.getTareas().observe(requireActivity()){
            val tasksAsText = it.joinToString("\n") { it.nombre }
            binding.tvRecuperado.text = tasksAsText
        }
    }
}