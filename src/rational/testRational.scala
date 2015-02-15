package rational

/**
 * Created by wolf on 1/7/15.
 */
object testRational {
  
  def main (args: Array[String]) {
    val rr = new Rational(3,5) * new Rational(3,7)

    val bb = new Rational(3,7).equals(new Rational(3,7))
    
    val rlist: List[Rational] = new Rational(7,11) :: List(new Rational(1,2), new Rational(1,3), new Rational(2), new Rational(31,32))

    class B extends Ordering[Rational] {
      override def compare(x: Rational, y: Rational): Int = x.getNumerator() * y.getDenominator() - y.getNumerator() * x.getDenominator()
    }
    
    println(rlist.sorted(new {} with Ordering[Rational] {
      override def compare(x: Rational, y: Rational): Int = x.getNumerator() * y.getDenominator() - y.getNumerator() * x.getDenominator()
    }))

    println("Less than: " + bb + " Rational: " + rr + " GCD: " + rr.getGCD())
  }

}
