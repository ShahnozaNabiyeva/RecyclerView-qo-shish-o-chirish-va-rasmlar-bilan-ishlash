package com.shahnoza.applicationexamples

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.button.MaterialButton
import com.shahnoza.applicationexamples.madel.MyObjectContact
import com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.R
import com.shahnoza.recyclerviewqoshishochirishvarasmlarbilanishlash.modul.MyContact

class AddActivity : AppCompatActivity() {
    lateinit var edtName:EditText
    lateinit var edtNumber:EditText
    lateinit var rbMan:RadioButton
    lateinit var rbWoman:RadioButton
    lateinit var rbBoy:RadioButton
    lateinit var rbGirl:RadioButton
    lateinit var rbStudent:RadioButton
    lateinit var rbTeacher:RadioButton
    lateinit var btnSave:MaterialButton
    var contactImage = R.drawable.man
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        edtName = findViewById(R.id.edtName)
        edtNumber = findViewById(R.id.edtNumber)
        rbMan = findViewById(R.id.rbMan)
        rbWoman = findViewById(R.id.rbWoman)
        rbBoy = findViewById(R.id.rbBoy)
        rbGirl = findViewById(R.id.rbGirl)
        rbStudent = findViewById(R.id.rbStudent)
        rbTeacher = findViewById(R.id.rbTeacher)
        btnSave = findViewById(R.id.btnSave)

        rbMan.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                contactImage = R.drawable.man
            }
        }
        rbWoman.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                contactImage = R.drawable.woman
            }
        }
        rbBoy.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                contactImage = R.drawable.boy
            }
        }
        rbGirl.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                contactImage = R.drawable.girl
            }
        }
        rbStudent.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                contactImage = R.drawable.student
            }
        }
        rbTeacher.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                contactImage = R.drawable.teacher
            }
        }

        btnSave.setOnClickListener {
            var name = edtName.text.toString().trim()
            var number = edtNumber.text.toString().trim()
            MyObjectContact.list.add(MyContact(name,number,contactImage))
            if (MyObjectContact.list.isNotEmpty()){
                Toast.makeText(this, "Saqlandi!", Toast.LENGTH_SHORT).show()
                edtName.text.clear()
                edtNumber.text.clear()
            }
        }

    }
}