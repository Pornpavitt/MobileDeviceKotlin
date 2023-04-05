package com.example.ass8mysql

import Employee
import retrofit2.http.*

interface EmployeeAPI {
    @GET("allemp")
    fun retrieveStudent(): retrofit2.Call<List<Employee>>

    @FormUrlEncoded
    @POST("addemp")
    fun insertStd(
        @Field("emp_name") emp_name: String,
        @Field("emp_gender") emp_gender:String,
        @Field("emp_email") emp_email: String,
        @Field("emp_salary") emp_salary: Int
    ): retrofit2.Call<Employee>

}
