package com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shahnoza.applicationexamples.AddActivity
import com.shahnoza.applicationexamples.madel.MyObjectContact
import com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.adadpter.MyrecyclerAdapter
import com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.modul.MyContact

class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var myrecyclerAdapter: MyrecyclerAdapter
    lateinit var list: ArrayList<MyContact>
    lateinit var btnAddContact: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        btnAddContact = findViewById(R.id.btnAddContact)
        list = ArrayList()
        list.add(MyContact("Aziz","+998907769796",R.drawable.student))
        list.add(MyContact("rrasul","+998907769496",R.drawable.teacher))
        list.add(MyContact("Bilol","+998907369796",R.drawable.man))
        list.add(MyContact("Guli","+998907766796",R.drawable.woman))
        list.add(MyContact("Jamshid","+998904769796",R.drawable.student))
        list.add(MyContact("Jahongir","+998905766796",R.drawable.student))
        list.add(MyContact("Jalol","+998907769791",R.drawable.teacher))
        list.add(MyContact("Doniyor","+998907769593",R.drawable.teacher))
        list.add(MyContact("Hurshida","+998907769793",R.drawable.girl))
        list.add(MyContact("Bobur","+998907769792",R.drawable.man))


        myrecyclerAdapter = MyrecyclerAdapter(this,list,object :MyrecyclerAdapter.MyItemClick{
            override fun onClick(myContact: MyContact, position: Int) {
                list.remove(myContact)
                myrecyclerAdapter.deleteContact(MyContact())
                Toast.makeText(this@MainActivity, "O`chirildi!", Toast.LENGTH_SHORT).show()
            }
        })


        rv.adapter = myrecyclerAdapter

        btnAddContact.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        if (MyObjectContact.list.isNotEmpty()){
            list.addAll(MyObjectContact.list)
            MyObjectContact.list.clear()
            myrecyclerAdapter.notifyDataSetChanged()
        }
    }
}