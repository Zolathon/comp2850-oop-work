import kotlin.random.Random

fun main() {
    rollDice(readInt("Enter number of sides: "), readInt("Enter number of dice: "))
    // rollDie(readInt("Enter number of sides: "))
}

fun readInt(phrase: String) : Int {
    print(phrase)
    var number = readln()
    if (number == "") {
        number = "6"
    }
    return number.toInt()
}

fun rollDie(sides: Int = 6) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun rollDice(sides: Int = 6, number: Int = 1) {
    for (i in 0..number-1) {
        rollDie(sides)
    }
}