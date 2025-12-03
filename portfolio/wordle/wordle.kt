import java.io.File
import kotlin.random.Random

val reset = "\u001B[0m"
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val colours = arrayOf(red, yellow, green, reset)
var target = pickRandomWord(readWordList("data/words.txt"))

fun main() {
    for (i in 1..6) {
        var guess = obtainGuess(i)
        var matches = evaluateGuess(guess, target)
        displayGuess(guess, matches)
    }
    
}

fun isValid(word : String): Boolean {
    if (word == "help!") {
        return true
    }
    if (word.length != 5) {
        return false
    }
    for (c in word) {
        if (!c.isLetter()) {
            return false
        }
    }
    return true
}

fun readWordList(filename: String): MutableList<String> {
    return File(filename).readLines().toMutableList()
}

fun pickRandomWord(words: MutableList<String>): String {
    return words[Random.nextInt(0, words.size)].toLowerCase()
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val guess = readLine()!!.toLowerCase()

        if (guess == "help!") {
            println("Target word: $target")
            continue
        }

        if (isValid(guess)) return guess
        println("Try Again, enter a 5 letter word")
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    var counts = mutableMapOf<Char, Int>()
    var matches : MutableList<Int> = mutableListOf(0, 0, 0, 0, 0)
    for (c in target) {
        counts[c] = (counts[c] ?: 0) + 1
    }
    for (i in 0..4) {
        if (guess[i] == target[i] && counts.getValue(guess[i]) != 0) {
            matches[i] = 2
            counts[guess[i]] = counts.getValue(guess[i]) - 1
        }
    }
    for (i in 0..4) {
        if (guess[i] in target && counts.getValue(guess[i]) != 0) {
            matches[i] = 1
        }
    }
    return matches
}

fun displayGuess(guess: String, matches: List<Int>) {
    print("\u001b[1A")
    print("\u001b[11C")
    print("\u001b[K")
    var result = ("${colours[matches[0]]}${guess[0]}${colours[matches[1]]}${guess[1]}${colours[matches[2]]}${guess[2]}${colours[matches[3]]}${guess[3]}${colours[matches[4]]}${guess[4]}")
    println("${result}${colours[3]}")
}