package fibonacci
import scala.annotation.tailrec

def fibonacci_Iterative(position: Int): Seq[Int] = position match {
  case 0 => Seq(1)
  case 1 => Seq(1, 1)
  case _ =>
    (2 to position).foldLeft(Seq(1, 1)) { (series, _) => series :+ series.takeRight(2).sum }
}

def fibonacci_Recursive(position: Int): Seq[Int] = position match {
    case 0 => Seq(1)
    case 1 => Seq(1, 1)
    case _ => {
      val series = fibonacci_Recursive(position - 1) 
      series :+ series.takeRight(2).sum 
    }
}

@tailrec
def fibonacci_Recursive_Iterative(position: Int, series: Seq[Int] = Seq(1)): Seq[Int] = position match {
 case 0 => series
 case _ => fibonacci_Recursive_Iterative(position - 1, series :+ series.takeRight(2).sum)
}

