package com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.adadpter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.R
import com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.modul.MyContact

class MyrecyclerAdapter(var context: Context,var contactList: ArrayList<MyContact>,var myItemClick: MyItemClick):RecyclerView.Adapter<MyrecyclerAdapter.MyViewHolder>() {


    inner class MyViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView){

        fun onBind(myContact: MyContact,position: Int){
        var name=itemView.findViewById<TextView>(R.id.itemContactName)
        var number=itemView.findViewById<TextView>(R.id.itemContactNumber)
        var image=itemView.findViewById<ImageView>(R.id.itemImageView)
        name.text=myContact.name
        number.text=myContact.number
        image.setImageDrawable(ContextCompat.getDrawable(context,myContact.image!!))
        itemView.setOnClickListener {
            myItemClick.onClick(myContact,position)
            true
        }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
    val myViewHolder=MyViewHolder(itemView)
    return myViewHolder

    }

    override fun getItemCount(): Int {
    return contactList.size

    }
    @SuppressLint("NotifyDataSetChanged")
    fun deleteContact(myContact: MyContact){
        contactList.remove(myContact)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

   val myContact=contactList[position]
        holder.onBind(myContact,position)

    }

    interface MyItemClick{
        fun onClick(myContact: MyContact,position: Int)
    }

}