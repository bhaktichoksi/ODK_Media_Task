package com.example.ODKTask.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ODKTask.R
import com.example.ODKTask.model.ResultsItem
import com.example.ODKTask.viewmodel.DeatilChaterViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    var result:ArrayList<ResultsItem> = ArrayList()
    var TAG = "DetailActivity"
    private lateinit var deatilChaterViewModel: DeatilChaterViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("id",0)

        deatilChaterViewModel = ViewModelProvider(this).get(DeatilChaterViewModel::class.java)

        deatilChaterViewModel.getDetails(id.toString())!!.observe(this, Observer { serviceSetterGetter ->

            Glide.with(this).load(serviceSetterGetter.data!!.results?.get(0)!!.thumbnail!!.path + "." + serviceSetterGetter!!.data!!.results?.get(0)!!.thumbnail!!.extension ).into(ivChater)
            chaterName.text = serviceSetterGetter.data.results?.get(0)!!.name

            if (!serviceSetterGetter.data.results[0].description.isNullOrBlank()){
                tvDec.text = "Information :- " + serviceSetterGetter.data.results[0].description
            }else{
                tvDec.text = "Information :- " + "Not Provided"
            }

            tvModeDetail.setOnClickListener {

                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("url", serviceSetterGetter.data.results[0].urls?.get(0)!!.url)
                startActivity(intent)

            }
        })

    }
}