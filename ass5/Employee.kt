package com.example.ass05intent
import android.os.Parcel
import android.os.Parcelable
data class Employee(val name:String, val gender: String, val Email:String,
                    val Salary: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(gender)
        parcel.writeString(Email)
        parcel.writeInt(Salary)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }
        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}