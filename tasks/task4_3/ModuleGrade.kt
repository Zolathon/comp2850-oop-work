import kotlin.math.roundToInt

fun main(argv: Array<String>) {
    var inputs = argv.toList()
    while (inputs.size != 3) {
        print("Input three integer scores\n>>> ")
        inputs = readln().split(" ")
    }
    val numbers = inputs.map {
        it.toInt()
    }
    val scores = numbers.map {
        it.toDouble()
    }
    val average = ((scores[0] + scores[1] + scores[2]) / 3).roundToInt()
    val grade = when (average) {
        in 70..100 -> 'A'
        in 40..69  -> 'B'
        in 0..39   -> 'C'
        else       -> 'U'
    }
    println("Final Grade: $grade")
}