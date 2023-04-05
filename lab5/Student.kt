package com.example.lab05internet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Student(val id:String, val name:String,val rank:String,val age:Int, val hobby:String) :Parcelable{

}