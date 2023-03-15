package com.jsanchezl.ttmapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jsanchezl.ttmapp.R
import com.jsanchezl.ttmapp.databinding.AlarmItemBinding
import com.jsanchezl.ttmapp.models.Alarma

class ECalendarioAdapter : RecyclerView.Adapter<ECalendarioAdapter.ECViewHolder>(){
    var alarmas :List<Alarma> = emptyList()

        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ECViewHolder {
        val withDataBinding: AlarmItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ECViewHolder.LAYOUT,
            parent,
            false)
        return ECViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ECViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.alarma = alarmas[position]
        }
        holder.viewDataBinding.root.setOnClickListener {
            val alarma = alarmas[position]
            if(alarma.typeAlarm == "C"){
                holder.viewDataBinding.root.findNavController().navigate(R.id.action_ec_to_eClasica)
            }else if(alarma.typeAlarm == "NV"){
                holder.viewDataBinding.root.findNavController().navigate(R.id.action_ec_to_envoz)
            }
        }
    }

    override fun getItemCount(): Int {
        return alarmas.size
    }
    class ECViewHolder(val viewDataBinding: AlarmItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.alarm_item
        }
    }
}