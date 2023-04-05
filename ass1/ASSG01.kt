package com.example.mobile_device.lab1andass1

fun main(){
    val scores = arrayOf(48, 65, 71, 81, 56);
    displayBorder()
    CalculateGPAX(scores);
    displayBorder()
}
fun displayBorder(charactor:Char ='-',length: Int=44){
    for (i in 1..length){
        print(charactor)
    }
    println()
}
fun CalculateGPAX(items :Array<Int>){
    val grades = mutableMapOf(
        "A" to 4.0, "B+" to 3.5, "B" to 3.0, "C+" to 2.5, "C" to 2.0, "D+" to 1.5, "D" to 1, "F" to 0.0);
    var grade:String?=null;
    var result: MutableList<Double> = mutableListOf<Double>()

    println("There are ${items.size} subjects in array.");
    for ((index, value) in items.withIndex()){
        when{
            (value>=80 && value<=100)->grade = "A";
            (value>=75)->grade = "B+";
            (value>=70)->grade = "B";
            (value>=65)->grade = "C+";
            (value>=60)->grade = "C";
            (value>=55)->grade = "D+";
            (value>=50)->grade = "D";
            else ->grade = "F";
        }
        result.add(grades[grade] as Double);
        println("Grade of Subject Number ${index+1} : $value = $grade : ${grades[grade]}");
        displayBorder()
    }
    print("GPAX = (");
    var total:Double=0.0;
    for ((i,j) in result.withIndex()){
        total += (result[i]*3);
        if(i==result.size-1){
            print("($j*3)) / ${3*result.size} = ${total/(3*result.size)}\n");
        }else {
            print("($j*3) + ");
        }
    }
}