package guessFile

import kotlin.random.Random

enum class Comparison {
  LOW, HIGH, EQUAL
}

fun evaluateGuess(guess: Int, target: Int): Comparison = when {
  guess > target -> Comparison.HIGH
  guess < target -> Comparison.LOW
  else -> Comparison.EQUAL
}

fun playGame(target: Int, getGuess: () -> Int, displayResult: (Comparison, Int) -> Unit) {
  generateSequence(1) { it + 1 }
    .map { Pair(getGuess(), it) }
    .map { Pair(evaluateGuess(it.first, target), it.second) }
    .onEach { displayResult(it.first, it.second) }
    .takeWhile { it.first != Comparison.EQUAL }
    .lastOrNull()
}

fun getGuess(): Int {
  return readLine()?.toIntOrNull() ?: 0
}

fun displayResult(result: Comparison, attempt: Int) {
  println("Attempt $attempt: $result")
}

fun generateRandomNumber(min: Int, max: Int): Int {
  return (min..max).random()
}

fun main() {
  println("Try to guess the Number: ")
  val target = generateRandomNumber(1, 100)

  playGame(target, ::getGuess, ::displayResult)
}
