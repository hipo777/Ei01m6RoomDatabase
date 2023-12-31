package org.demre.ei01m6roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.demre.ei01m6roomdatabase.databinding.ActivityMainBinding
/*
    [x] Navigation
    [x] Fragmento para agregar
    [x] Crear Interfaz
    [x] Room
        [x] Dao
        [x] BaseDatos
        [x] Entity
    [] RecyclerView
    [] Fragmento para listado


 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var appDb : AppDatabase
    //private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
