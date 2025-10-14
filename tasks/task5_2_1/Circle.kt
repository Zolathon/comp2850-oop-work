import kotlin.math.PI

fun main() {
    val radius = readDouble("Input radius: ")
    println("Circle area: ${circleArea(radius)}")
    println("Circle perimeter: ${circleCircumference(radius)}")
}


fun circleArea(radius: Double) = PI * radius * radius

fun circleCircumference(radius: Double) = 2 * PI * radius

fun readDouble(phrase: String) : Double {
    print(phrase)
    val number = readln()
    return number.toDouble()
}