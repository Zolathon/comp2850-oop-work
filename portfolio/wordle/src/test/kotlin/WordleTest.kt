import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File


@Suppress("unused")
class WordleTest : StringSpec({

    "isValid should accept valid words" {
        isValid("xxxxx") shouldBe true
        isValid("hello") shouldBe true
        isValid("apple") shouldBe true
    }

    "isValid should not accept invalid words" {
        isValid("xxxx") shouldBe false
        isValid("xxxxxx") shouldBe false
        isValid("hell0") shouldBe false
        isValid("4ppl£") shouldBe false
    }

    "evaluateGuess should be all green" {
        evaluateGuess("xxxxx", "xxxxx") shouldBe listOf(2, 2, 2, 2, 2)
    }

    "evaluateGuess should be all yellow" {
        evaluateGuess("hello", "lloeh") shouldBe listOf(1, 1, 1, 1, 1)
    }

    "evaluateGuess should be all red" {
        evaluateGuess("hello", "xxxxx") shouldBe listOf(0, 0, 0, 0, 0)
    }

    "evaluateGuess bug case, letters being flagged as yellow too soon" {
        evaluateGuess("rumor", "tumor") shouldBe listOf(0, 2, 2, 2, 2)
        evaluateGuess("silos", "kilos") shouldBe listOf(0, 2, 2, 2, 2)
    }

    "readWordList should return mutableListOf containing the same strings" {
        // Using a temp files to show it works with different size files
        val tempFileOne = File.createTempFile("words1", ".txt")
        val tempFileTwo = File.createTempFile("words2", ".txt")
        tempFileOne.writeText("xxxxx\nhello\napple")
        tempFileTwo.writeText("hello\nxxxxx\napple\ntumor\nrumor")

        var words = readWordList(tempFileOne.absolutePath)
        words shouldBe mutableListOf("xxxxx", "hello", "apple")
        
        words = readWordList(tempFileTwo.absolutePath)
        words shouldBe mutableListOf("hello", "xxxxx", "apple", "tumor", "rumor")
    }

    "pickRandomWord should return a valid word from the file" {
        val tempFileOne = File.createTempFile("words1", ".txt")
        
        tempFileOne.writeText("xxxxx\nhello\napple")

        val words = readWordList(tempFileOne.absolutePath)

        val result = pickRandomWord(words)

        // Must be valid
        isValid(result) shouldBe true

        // Must come from the list
        (result in words.map { it.lowercase() }) shouldBe true

        tempFileOne.delete()
    }


})
