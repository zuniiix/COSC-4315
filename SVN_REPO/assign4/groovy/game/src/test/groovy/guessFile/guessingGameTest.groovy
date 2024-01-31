package guessFile

import spock.lang.*

class GuessingGameTest extends Specification {
  def "canary test"() {
    expect:
    true
  }
    
  void testPlayGuessingGameHigh() {
    def guess = 94
    def target = 42

    def result = evaluateGuess(guess, target)

    assert result == Comparison.HIGH
  }

  void testPlayGuessingGameLow() {
    def guess = 10
    def target = 42

    def result = evaluateGuess(guess, target)

    assert result == Comparison.LOW
  }

  void testPlayGuessingGameEqual() {
    def guess = 42
    def target = 42

    def result = evaluateGuess(guess, target)

    assert result == Comparison.EQUAL
  }

  void testPlayGame() {
    def input = { 50 }
    def totalAttempts = 0

    def displayResults = { result, attempts ->
        assert result == Comparison.EQUAL
        totalAttempts = attempts
    }

    playGame(50, input, displayResults)

    assert totalAttempts == 1
    }

  void testPlayGameTwoAttemptsLow() {
    def guesses = [30, 42]
    def numberOfInputCalls = 0
    def numberOfOutputCalls = 0

    def input = { guesses[numberOfInputCalls++] }

    def displayResults = { result, attempts ->
        numberOfOutputCalls++
        switch (attempts) {
            case 1:
                assert result == Comparison.LOW
                break
            case 2:
                assert result == Comparison.EQUAL
                break
        }
    }

    playGame(42, input, displayResults)

    assert numberOfInputCalls == 2
    assert numberOfOutputCalls == 2
  }

  void testPlayGameTwoAttemptsHigh() {
    def guesses = [50, 42]
    def numberOfInputCalls = 0
    def numberOfOutputCalls = 0

    def input = { guesses[numberOfInputCalls++] }
    def displayResults = { result, attempts ->
        numberOfOutputCalls++
        switch (attempts) {
            case 1:
                assert result == Comparison.HIGH
                break
            case 2:
                assert result == Comparison.EQUAL
                break
        }
    }

    playGame(42, input, displayResults)

    assert numberOfInputCalls == 2
    assert numberOfOutputCalls == 2
  }

  void testRandomNumberGeneratorWithinRange() {
    def target = generateRandomNumber(1, 100)

    assert target >= 1 && target <= 100
  }

  void testRandomNumberGeneratorReturnsTwoDifferentValues() {
    def target1 = generateRandomNumber(1, 100)
    def target2 = generateRandomNumber(1, 100)

    assert target1 != target2
  }

}
