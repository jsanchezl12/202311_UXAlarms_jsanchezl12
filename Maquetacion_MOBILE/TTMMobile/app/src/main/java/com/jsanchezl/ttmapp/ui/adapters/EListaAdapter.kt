package com.jsanchezl.ttmapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jsanchezl.ttmapp.R
import com.jsanchezl.ttmapp.databinding.AlarmItemBinding
import com.jsanchezl.ttmapp.models.Alarma

class EListaAdapter : RecyclerView.Adapter<EListaAdapter.EListaViewHolder>(){
    var alarmas :List<Alarma> = emptyList()

        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EListaViewHolder {
        val withDataBinding: AlarmItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            EListaViewHolder.LAYOUT,
            parent,
            false)
        return EListaViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: EListaViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.alarma = alarmas[position]
        }
        holder.viewDataBinding.root.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return alarmas.size
    }
    class EListaViewHolder(val viewDataBinding: AlarmItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.alarm_item
        }
    }
}