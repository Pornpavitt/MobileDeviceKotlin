package com.example.mobile_device.lab1andass1

import com.example.mobile_device.lab.Person

fun main(){
    val sub1 = Subject(id="SC362001", name = "Mobile Device Programming", credit = 3)
    val sub2 = Subject(id="SC362002", name = "Basic of Data Engineering", credit = 3)
    val sub3 = Subject(id="SC362003", name = "Web Application Programing", credit = 3)

    var STD = Student(fName = "Pornpavit", lName = "Thayommai", deptName = "Information Technology");
    println("Member NO.4: ${STD.firstName} ${STD.lastName}");
    STD.showDetail()
    STD.gradeEnroll(sub1, score = 60)
    STD.gradeEnroll(sub2, score = 75)
    STD.gradeEnroll(sub3, score = 90)
    STD.displayGpa();
}

//data class
data class Subject(val id:String, val name:String, val credit:Int);

class Student(fName:String, lName:String, deptName:String): Person(fName,lName,deptName){
    var creditTotal: Int = 0;
    var gradeTotal: Double = 0.0;
    override fun showDetail(){
        println("$firstName is a student at $department.");
    }
    fun gradeEnroll(subj:Subject,score:Int){
        var grade:String ="";
        val grades = mutableMapOf(
            "A" to 4.0, "B+" to 3.5, "B" to 3.0, "C+" to 2.5, "C" to 2.0, "D+" to 1.5, "D" to 1, "F" to 0.0);
        when{
            score<50->grade="F"
            score<55->grade="D"
            score<60->grade="D+"
            score<65->grade="C"
            score<70->grade="C+"
            score<75->grade="B"
            score<80->grade="B+"
            score>=80->grade="A"
        }
        creditTotal += subj.credit
        gradeTotal += (grades[grade] as Double)*subj.credit
        println("${subj.toString()} Score: $score, Grade: $grade")
    }
    fun displayGpa(){
        println("$firstName $lastName's GPA is "+String.format("%.2f", gradeTotal/creditTotal));
    }
}