package com.example.kotlincoding
//import com.example.kotlincoding.Calculator
//import com.example.kotlincoding.AddOperation
//import com.example.kotlincoding.SubtractOperation
//import com.example.kotlincoding.MultiplyOperation
//import com.example.kotlincoding.DivideOperation
//import com.example.kotlincoding.ModuloOperation

private var readnum1:Int = 0
private var readnum2:Int = 0
private var calc:String = ""




fun main() {
    println("========== 계산기 ==========")
    println("숫자를 입력하세요")
    readnum1 = readLine()!!.toInt()

    while (true) {

        println(" 행동을 선택하세요 : 1. 더하기(+) / 2. 빼기(-) / 3. 곱하기(*) / 4. 나누기(/) / 5. 나머지(%) / 0. 리셋 / -1. 닫기 " )
        calc = readLine()!!.toString()
        when(calc){
            "0", "리셋" -> {
                println("========== 계산 내용을 리셋합니다 ==========")
                println("숫자를 입력하세요")
                readnum1 = readLine()!!.toInt()
                continue
            }

            "1", "더하기", "+" -> calc = "1"
            "2", "빼기", "-" -> calc = "2"
            "3", "곱하기", "*" -> calc = "3"
            "4", "나누기", "/" -> calc = "4"
            "5", "나머지", "%" -> calc = "5"

            else -> {
                println("========== 계산기를 종료합니다 ==========")
                break
        }
        }

        println("숫자를 입력하세요")
        readnum2 = readLine()!!.toInt()

        var result = when (calc) {
            "1" -> AddOperation(readnum1, readnum2)

            "2" -> SubtractOperation(readnum1, readnum2)

            "3" -> MultiplyOperation(readnum1, readnum2)

            "4" -> DivideOperation(readnum1, readnum2)

            "5" -> ModuloOperation(readnum1, readnum2)

            else -> {break}
        }
        result.계산()

        readnum1 = result.num3
        println("========== 이어서 계산합니다 ==========")
        println("${readnum1}")

    }
}

open class Calculator (var num1:Int, var num2:Int) {
    var num3: Int = 0

    fun 계산(){
        print("[계산 결과] ")
        print("${num1}")

        when(calc){
            "1" -> print( " + " )
            "2" -> print( " - " )
            "3" -> print( " * " )
            "4" -> {
                println( " / ${num2} 는 ${num3}로 나누어지고, 나머지는 ${ModuloOperation(readnum1, readnum2).num3}야" )
                return
            }
            "5" -> {
                println( " / ${num2} 는 ${DivideOperation(readnum1, readnum2).num3}로 나누어지고, 나머지는 ${num3}야" )
                return
            }
        }

        println("${num2} = ${num3}")
    }
}

class AddOperation(num1:Int,num2:Int) :Calculator(num1,num2) {
    init {
        num3 = num1 + num2
    }
}

class SubtractOperation(num1:Int, num2:Int) :Calculator(num1,num2) {
    init {
        num3 = num1-num2
    }
}

class MultiplyOperation(num1:Int, num2:Int) :Calculator(num1,num2) {
    init {
        num3 = num1*num2
    }
}

class DivideOperation(num1:Int, num2:Int) :Calculator(num1,num2) {
    init {
        num3 = num1/num2
    }
}

class ModuloOperation(num1:Int, num2:Int) :Calculator(num1,num2) {
    init {
        num3 = num1 % num2
    }
}