// Task 5.2.2: conversion of marks into grades, using a function
fun main(argv: Array<String>) {
    val marks = argv.map{ it.toInt() }
    for (i in 0..argv.size-1) {
        println("${marks[i]} is a ${grade(marks[i])}")
    }
}

fun grade(mark: Int) = when (mark) {
    in 0..39   -> "Fail"
    in 40..69  -> "Pass"
    in 70..100 -> "Distinction"
    else       -> "?"
}
