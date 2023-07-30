package org.demre.ei01m6roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.demre.ei01m6roomdatabase.databinding.FragmentAgregarBinding

class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    private val tareaVM: TareaVM by activityViewModels()
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
        binding.btnIngresar.setOnClickListener() {
            val texto = binding.etIngreso.text.toString()
            guardarTarea(texto)
        }
    }

    private fun guardarTarea(texto: String) {

        val tarea = Tarea(texto)
        tareaVM.insertarTareas(tarea)

    }

    private fun recuperarTareas() {

        tareaVM.obtenerTareas().observe(viewLifecycleOwner) {
            val tasksAsText = it.joinToString("\n") { it.nombre }
            binding.tvRecuperado.text = tasksAsText
        }
    }
}