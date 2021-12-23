package com.syafii.app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.transform.CircleCropTransformation
import com.syafii.app.R
import com.syafii.app.databinding.ItemUserBinding
import com.syafii.app.ui.adapters.listener.OnLastItem
import com.syafii.domain.UserDomain

class UserAdapter(
    private val items: List<UserDomain>
) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var onLastitem: OnLastItem? = null
    fun loadMoreListener(lastItem: OnLastItem) {
        onLastitem = lastItem
    }

    inner class MyViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: UserDomain) {
            binding.run {
                tvFirstName.text = item.firstName
                tvLastName.text = item.lastName
                tvEmail.text = item.email
                ivUser.load(item.avatar) {
                    crossfade(true)
                    placeholder(R.mipmap.ic_launcher)
                    transformations(CircleCropTransformation())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(items[position])

        if (position == itemCount - 1) {
            onLastitem?.loadmore()
        }
    }

    override fun getItemCount(): Int = items.size

}