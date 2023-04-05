package com.example.myapplication.lab1kotlin

fun main(){
    val subjectScore = arrayOf(67,52,73,85,42,78)
    println("There are "+ subjectScore.size + " subjects in array.")
    displayBorder()
    CalculateGrade(subjectScore)
}
fun displayBorder(charactor:Char ='-',length: Int=37){
    for (i in 1..length){
        print(charactor)
    }
    println()
}
fun CalculateGrade(scoreArr : Array<Int>){
    var i :Int=1
    var grade:String
    for (value in scoreArr){
        when{
            value <50 -> grade = "F"
            value <55 -> grade = "D"
            value <60 -> grade = "D+"
            value <65 -> grade = "C"
            value <70 -> grade = "C+"
            value <75 -> grade = "B"
            value <80 -> grade = "B+"
            else -> grade = "A"
        }
        println(" Grade of Subject Number $i : $value = $grade")
        displayBorder()
        i++
    }
}