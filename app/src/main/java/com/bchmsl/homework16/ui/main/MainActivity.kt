package com.bchmsl.homework16.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bchmsl.homework16.adapters.LoaderAdapter
import com.bchmsl.homework16.adapters.UserAdapter
import com.bchmsl.homework16.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userAdapter by lazy { UserAdapter() }
    private val loaderAdapter by lazy {LoaderAdapter()}
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
    }

    private fun start() {
        binding.rvUsers.adapter = userAdapter.withLoadStateFooter(loaderAdapter)
        getUsers()
    }

    private fun getUsers() {
        lifecycleScope.launch {
            viewModel.getUsers()
            viewModel.responseFlow.collect {
                userAdapter.submitData(it)
            }
        }
    }
}