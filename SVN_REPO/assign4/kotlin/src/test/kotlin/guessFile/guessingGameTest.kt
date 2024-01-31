package guessFile

import kotlin.test.Test
import kotlin.test.assertEquals

class GuessingGameTest {

  @Test 
  fun testPlayGuessingGameHigh() {
    val guess = 94  
    val target = 42 
        
    val result = evaluateGuess(guess, target)
        
    assertEquals(Comparison.HIGH, result) 
  }
        
  @Test
  fun testPlayGuessingGameLow() {
    val guess = 10  
    val target = 42 
        
    val result = evaluateGuess(guess, target)
        
    assertEquals(Comparison.LOW, result) 
  }
        
  @Test
  fun testPlayGuessingGameEqual() {
    val guess = 42  
    val target = 42 
        
    val result = evaluateGuess(guess, target)
        
    assertEquals(Comparison.EQUAL, result) 
  }

  @Test
  fun testPlayGame() {
    val input: () -> Int = { 50 }
    var totalAttempts = 0
    val displayResults: (Comparison, Int) -> Unit = { result, attempts ->
      assertEquals(Comparison.EQUAL, result)
      totalAttempts = attempts
    }

    playGame(50, input, displayResults)

    assertEquals(1, totalAttempts)
  }

  @Test
  fun testPlayGameTwoAttemptsLow() {
    val guesses = listOf(30, 42)
    var numberOfInputCalls = 0
    var numberOfOutputCalls = 0

    val input: () -> Int = { guesses[numberOfInputCalls++] }

    val displayResults: (Comparison, Int) -> Unit = { result, attempts ->
      numberOfOutputCalls++
      when (attempts) {
        1 -> assertEquals(Comparison.LOW, result)
        2 -> assertEquals(Comparison.EQUAL, result)
      }
    }

    playGame(42, input, displayResults)

    assertEquals(2, numberOfInputCalls)
    assertEquals(2, numberOfOutputCalls)
  }

  @Test
  fun testPlayGameTwoAttemptsHigh() {
    val guesses = listOf(50, 42)
    var numberOfInputCalls = 0
    var numberOfOutputCalls = 0

    val input: () -> Int = { guesses[numberOfInputCalls++] }

    val displayResults: (Comparison, Int) -> Unit = { result, attempts ->
      numberOfOutputCalls++
      when (attempts) {
        1 -> assertEquals(Comparison.HIGH, result) 
        2 -> assertEquals(Comparison.EQUAL, result)
      }
    }

    playGame(42, input, displayResults)

    assertEquals(2, numberOfInputCalls)
    assertEquals(2, numberOfOutputCalls)
  }

  @Test
  fun testRandomNumberGeneratorWithinRange() {
    val target = generateRandomNumber(1, 100)
    
    assertEquals(true, target in 1..100)
  }

  @Test
  fun testRandomNumberGeneratorReturnsTwoDifferentValues() {
    val target1 = generateRandomNumber(1, 100)
    val target2 = generateRandomNumber(1, 100)

    assertEquals(false, target1 == target2)
  }
}
