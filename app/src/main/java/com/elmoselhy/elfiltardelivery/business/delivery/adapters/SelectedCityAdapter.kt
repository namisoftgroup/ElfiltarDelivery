package com.elmoselhy.elfiltardelivery.business.delivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elmoselhy.elfiltardelivery.base.BaseAdapter
import com.elmoselhy.elfiltardelivery.base.BaseModel
import com.elmoselhy.elfiltardelivery.commons.models.BaseSelection
import com.elmoselhy.elfiltardelivery.databinding.ItemLayoutSelectedCityBinding

class SelectedCityAdapter(
    var itemsList: ArrayList<BaseModel>,
    private val onItemRemoved: (Int, BaseModel) -> Unit,
) :
    BaseAdapter<SelectedCityAdapter.CustomViewHolder, BaseModel>(itemsList) {
    //Custom View Holder
    open class CustomViewHolder(var binding: ItemLayoutSelectedCityBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    //onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = ItemLayoutSelectedCityBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)
    }

    //onBindViewHolder
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        setUpData(holder, position)
        setUpActions(holder, position)
    }

    private fun setUpData(holder: CustomViewHolder, position: Int) {
        holder.binding.tvName.text = itemsList[position].title
    }

    private fun setUpActions(holder: CustomViewHolder, position: Int) {
        holder.binding.ivRemove.setOnClickListener {
            onItemRemoved(position, itemsList[position])
        }
    }

}