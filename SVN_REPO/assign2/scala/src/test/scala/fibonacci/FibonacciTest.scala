package fibonacci
import org.scalatest.funsuite.AnyFunSuite

class FibonacciTest extends AnyFunSuite {

  def testFibonacciFunction(fibonacciFunction: Int => Seq[Int], functionName: String): Unit = {
    test(s"Testing $functionName") {
      val testCases = Map(
        0 -> Seq(1),
        1 -> Seq(1, 1),
        2 -> Seq(1, 1, 2),
        5 -> Seq(1, 1, 2, 3, 5, 8),
        10 -> Seq(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
      )

      testCases.foreach { case (position, expected) =>
        val result = fibonacciFunction(position)
        assert(result == expected, s"Expected $expected for position $position")
      }
    }
  }

  testFibonacciFunction(fibonacci_Iterative, "Iterative")
  testFibonacciFunction(fibonacci_Recursive, "Recursive")
  testFibonacciFunction(fibonacci_Recursive_Iterative(_), "RecursiveIterative")
}
