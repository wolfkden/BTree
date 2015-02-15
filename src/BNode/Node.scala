package BNode

import org.apache.log4j._
/**
 * Created by wolf on 1/6/15.
 */

class Node[T](val value: T, children: List[Node[T]] = List[Node[T]]()) extends Ordered[Node[T]] {
  //extends ND[T](value, children) {

  type N[U] = U => Nothing
  type NN[U] = N[N[U]]
  type V2[U,X] = N[N[U] with N[X]]
  type V3[U,X,Y] = N[N[U] with N[X] with N[Y]]
  type V4[U,X,Y,Z] = N[N[U] with N[X] with N[Y] with N[Z]]
  //  NN[T]<:V3[Int,String,Ordered[T]]
  val evv: NN[T] <:< V4[Ordering[T],Int,Double,String] = null

  val ff: (Node[T]) => Int = try {
    value match {
      case x: Int => (that: Node[T]) => this.asInstanceOf[Node[Int]].value compare that.asInstanceOf[Node[Int]].value
      case x: Double => (that: Node[T]) => this.asInstanceOf[Node[Double]].value compare that.asInstanceOf[Node[Double]].value
      case x: Char => (that: Node[T]) => this.asInstanceOf[Node[Char]].value compare that.asInstanceOf[Node[Char]].value
      case x: String => (that: Node[T]) => this.asInstanceOf[Node[String]].value compare that.asInstanceOf[Node[String]].value
      case x: Ordered[T] => (that: Node[T]) => this.asInstanceOf[Node[Ordered[T]]].value compare that.value
    }

  } catch {
      case e: MatchError => println("Type Error: " + e.getMessage()); null
  } finally { }

  override def compare(that: Node[T]): Int = ff(that)

}
