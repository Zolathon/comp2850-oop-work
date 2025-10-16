fun main() {
    print("Enter your string: ")
    val string = readln()
    println(string.tooLong)
}

val String.tooLong: Boolean get() = this.length > 20