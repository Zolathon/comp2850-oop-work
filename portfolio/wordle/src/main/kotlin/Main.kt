fun main() {
    for (i in 1..6) {
        var target = pickRandomWord(readWordList("data/words.txt"))
        var guess = obtainGuess(i)
        var matches = evaluateGuess(guess, target)
        displayGuess(guess, matches)
    }
}