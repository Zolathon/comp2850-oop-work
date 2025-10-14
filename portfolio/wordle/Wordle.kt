import java.io.File
import kotlin.random.Random

val reset = "\u001B[0m"
val red = "\u001B[31m"
val green = "\u001B[32m"
val blue = "\u001B[34m"
val colours = arrayOf(red, green, blue, reset)

fun main() {
    var flags = arrayOf(0, 0, 0, 0, 0)
    val words = File("data/words.txt").readLines()
    val answer = words[Random.nextInt(0, words.size)].lowercase()
    val correct = arrayOf(1, 1, 1, 1, 1)
    while (!flags.contentEquals(correct)) {
        print("type your word: ")
        var guess = readln()
        if (guess == "help!") {
            println(answer)
            continue
        }
        flags = checkAnswer(answer, guess, flags)
        formatGuess(guess, flags)
        
    }
    println("YOU WON!!!")
}

fun formatGuess(guess: String, flags: Array<Int>) {
    print("\u001b[1A")
    print("\u001b[2K")
    var result = ("${colours[flags[0]]}${guess[0]}${colours[flags[1]]}${guess[1]}${colours[flags[2]]}${guess[2]}${colours[flags[3]]}${guess[3]}${colours[flags[4]]}${guess[4]}")
    println("                ${result}${colours[3]}")
}

fun checkAnswer(answer: String, guess: String, flags: Array<Int>) : Array<Int> {
    for (i in 0..4) {
        if (guess[i] !in answer) {
            flags[i] = 0
            continue
        }
        else if (guess[i] == answer[i]) {
            flags[i] = 1
        }
        else {
            flags[i] = 2
        }
    }
    return flags
}