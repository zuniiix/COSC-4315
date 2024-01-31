package guessFile

enum Comparison {
  LOW, HIGH, EQUAL
}

def evaluateGuess(int guess, int target) {
  switch (guess <=> target) {
    case 1: return Comparison.HIGH
    case -1: return Comparison.LOW
    case 0: return Comparison.EQUAL
  }
}

def playGame(target, getGuess, displayResult) {
  def playRecursive
  playRecursive = { innerTarget, innerAttempts ->
    def guess = getGuess.call()
    def result = evaluateGuess(guess, innerTarget)
    displayResult.call(result, innerAttempts)
        
    if (result != Comparison.EQUAL) {
        playRecursive(innerTarget, innerAttempts + 1)
    }
  }
    
  playRecursive(target, 0)
}

def getGuess() {
  def input = System.in.newReader().readLine()
  input?.toInteger() ?: 0
}

def displayResult(result, attempt) {
  println("Attempt $attempt: $result")
}

def generateRandomNumber(min, max) {
  new Random().nextInt(max - min + 1) + min
}

println("Try to guess the Number: ")

def target = generateRandomNumber(1, 100)

playGame(target, this.&getGuess, this.&displayResult)
