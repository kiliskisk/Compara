package com.curso.android.app.practica.compara.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.curso.android.app.practica.compara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.texto.observe(this, Observer {
            binding.textViewResultado.text = it.txt1 + it.resultado +it.txt2
        })

        binding.btnComparar.setOnClickListener(){
            mainViewModel.asignar(binding.editText1.text.toString(),binding.editText2.text.toString())
        }
}}