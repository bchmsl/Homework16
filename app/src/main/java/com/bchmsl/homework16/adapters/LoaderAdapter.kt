package com.bchmsl.homework16.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework16.databinding.LayoutLoaderItemBinding

class LoaderAdapter:LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {

    inner class LoaderViewHolder(val binding: LayoutLoaderItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.binding.root.isVisible = loadState is LoadState.Loading
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) =
        LoaderViewHolder(LayoutLoaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
}