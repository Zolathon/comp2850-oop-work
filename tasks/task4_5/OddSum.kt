fun main(argv: Array<String>) {
    var sum = 0
    for (i in 0..<(argv[0].toInt())) {
        if (i % 2 != 0) {
            sum += i
        }
    }
    println(sum)
}