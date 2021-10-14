package com.example.ODKTask.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ODKTask.R
import com.example.ODKTask.adapter.MainAdapter
import com.example.ODKTask.model.Data
import com.example.ODKTask.model.ResultsItem
import com.example.ODKTask.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    private lateinit var adapter: MainAdapter
    var data:ArrayList<Data> = ArrayList()
    var result:ArrayList<ResultsItem> = ArrayList()

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


            mainActivityViewModel.getUser(progress)!!.observe(this, Observer { serviceSetterGetter ->


                val msg = serviceSetterGetter.attributionHTML

                val data = serviceSetterGetter.data
                result = data!!.results!!
                recyclerView.layoutManager = LinearLayoutManager(this)
                adapter = MainAdapter(this,result)
                recyclerView.addItemDecoration(
                    DividerItemDecoration(
                        recyclerView.context,
                        (recyclerView.layoutManager as LinearLayoutManager).orientation
                    )
                )
                recyclerView.adapter = adapter

            })



    }
}
