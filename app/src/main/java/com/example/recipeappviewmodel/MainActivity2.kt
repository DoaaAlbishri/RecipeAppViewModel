package com.example.recipeappviewmodel

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {
    lateinit var myRv: RecyclerView
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}
    lateinit var Rv : RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        myRv = findViewById(R.id.recyclerView)
        Rv = RecyclerViewAdapter()
        myViewModel.getRecipes().observe(this, {
                recipes -> Rv.update(recipes)
            println("show")
        })
        myRv.adapter = Rv
        myRv.layoutManager = LinearLayoutManager(this)
    }
}