package com.example.recylerviewapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recylerviewapi.databinding.ActivityDetailBinding
import com.example.recylerviewapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object{private const val TAG = "MainActivity"}

    private lateinit var userAdapter: UserAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getUser()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter(arrayListOf())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
    }

    private fun getUser() {
        showLoading(true)
        val client = ApiConfig.getApiService().getUser()
        client.enqueue(object : Callback<MainModel>{
            override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                showLoading(false)
                if (response.isSuccessful){
                    showResult(response.body()!!)
                }
            }

            override fun onFailure(call: Call<MainModel>, t: Throwable) {
                Log.d(TAG, t.toString())
                showLoading(false)
            }

        })
    }

    private fun showResult(data: MainModel) {
        val results = data.result
        userAdapter.setData(results)
    }

    private fun showLoading(isLoading : Boolean) {
        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        if(isLoading){
            progressBar.visibility = View.VISIBLE
        }else{
            progressBar.visibility = View.GONE
        }
    }


}