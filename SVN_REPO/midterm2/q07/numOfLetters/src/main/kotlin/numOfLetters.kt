fun countLetters(string: String): Map<Char, Int> {
    tailrec fun countLettersRec(
        remaining: String,
        counts: Map<Char, Int>
    ): Map<Char, Int> {
        return if (remaining.isEmpty()) {
            counts
        } else {
            val currentLetter = remaining[0]
            val updatedCounts = counts + (currentLetter to (counts.getOrDefault(currentLetter, 0) + 1))
            countLettersRec(remaining.substring(1), updatedCounts)
        }
    }

    return countLettersRec(string, emptyMap())
}

fun printLetterCounts(letterCounts: Map<Char, Int>) {
    letterCounts.forEach { (letter, count) ->
        println("$letter: $count times")
    }
}

fun main() {
    print("Enter the string: ")
    val userInput = readLine().orEmpty()

    val letterCounts = countLetters(userInput)
    printLetterCounts(letterCounts)
}

