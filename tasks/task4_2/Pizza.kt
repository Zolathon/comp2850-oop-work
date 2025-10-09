fun main() {
    val options = arrayOf("a - Cheese", "b - Pepperoni", "c - Hawaiian", "d - Meaty")
    println("Type a, b, c, d or the name of your pizza of preference:\n")
    for (i in 0..3) {
        println(options[i])
    }
    print("\n>>> ")
    var response = readln().lowercase().toString()
    for (i in 0..3) {
        if (options[i][0].toString() == response || options[i].substring(4, options[i].length).lowercase() == response) {
            println("Order accepted for a ${options[i].substring(4, options[i].length)} Pizza!")
        }
    }
}