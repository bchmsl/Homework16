package com.bchmsl.homework16.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework16.databinding.LayoutUserBinding
import com.bchmsl.homework16.model.ApiResponse

class UserAdapter : PagingDataAdapter<ApiResponse.User, UserAdapter.UserViewHolder>(UserCallBack()) {
    inner class UserViewHolder(private val binding: LayoutUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val currentItem = getItem(absoluteAdapterPosition)
            binding.tvName.text = "${currentItem?.firstName} ${currentItem?.lastName}"
            binding.tvEmail.text = currentItem?.email
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UserViewHolder(
            LayoutUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    class UserCallBack: DiffUtil.ItemCallback<ApiResponse.User>(){
        override fun areItemsTheSame(
            oldItem: ApiResponse.User,
            newItem: ApiResponse.User
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ApiResponse.User,
            newItem: ApiResponse.User
        ): Boolean {
            return oldItem == newItem
        }

    }
}