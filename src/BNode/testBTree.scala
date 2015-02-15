package BNode

import rational.Rational

/**
 * Created by wolf on 1/6/15.
 */
object testBTree {
  
  def main(args: Array[String]): Unit = {
    val a = new Node(new Rational(1,3))
    val b = new Node(new Rational(1,4))
    println(a.value)
    print(a compare b)
    
  }

}
