package com.example.zeeshan.quiz1.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.zeeshan.quiz1.R
import com.example.zeeshan.quiz1.models.User

class ListAdapter(var ctx : Context, var myUserList: ArrayList<User>): RecyclerView.Adapter<ListAdapter.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var view = LayoutInflater.from(ctx).inflate(R.layout.card_row, null)
        var customViewHolder = CustomViewHolder(view)
        return customViewHolder
    }

    override fun getItemCount(): Int {
        return myUserList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val user = myUserList[position]
        holder.name_Tv.text = user.fullName
        holder.regNo_Tv.text = "" + user.regNo
        holder.studyGroup_Tv.text = user.studyGroup
    }



    inner class CustomViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var name_Tv: TextView = view.findViewById(R.id.name)
        var regNo_Tv: TextView = view.findViewById(R.id.regNo)
        var studyGroup_Tv: TextView = view.findViewById(R.id.studyGroup)
    }
}

//inner class CustomViewHolder(var view: View): RecyclerView.ViewHolder(View){}