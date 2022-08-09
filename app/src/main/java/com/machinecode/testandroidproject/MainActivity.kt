package com.machinecode.testandroidproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.machinecode.testandroidproject.adapter.PersonAdapter
import com.machinecode.testandroidproject.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var rvUserInfo: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUserInfo = findViewById(R.id.rv_user_info)

        val viewModel: UserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.getJsonDataFromAsset(baseContext, "data")
        viewModel.getUser().observe(this) {
            rvUserInfo.layoutManager =
                LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
            rvUserInfo.adapter = PersonAdapter(it)
        }
    }
}