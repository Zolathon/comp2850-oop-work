// Task 5.1.1: anagram checking using a function
fun main(argv: Array<String>) {
    var words = argv
    while (words.size != 2) {
        print("Enter first word: ")
        var word1 = readln()
        print("Enter second word: ")
        var word2 = readln()
    }
    println(anagrams(word1, word2))
}

fun anagrams(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }
    val firstChars = first.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars
}