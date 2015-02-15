package rational

/**
 * Created by wolf on 1/7/15.
 */
class Rational(numerator: Int, denominator: Int = 1) extends Ordered[Rational] {
  
  private val dsgn = if(denominator < 0) -1 else 1
  private val nm: Int = norm(if(numerator < 0) -numerator else numerator, if(denominator == 0) 1 else denominator)
  private val denom: Int = if(denominator == 0) 1 else dsgn * denominator / nm
  private val numer: Int = dsgn * numerator / nm
  
  def getDenominator(): Int = denom

  def getNumerator(): Int = numer
  
  def getGCD() = nm
  
  def +(that: Rational): Rational = new Rational(that.denom*this.numer+that.numer*this.denom,this.denom*that.denom)
  
  def -(that: Rational): Rational = new Rational(that.denom*this.numer-that.numer*this.denom,this.denom*that.denom)

  def *(that: Rational): Rational = new Rational(this.numer*that.numer,this.denom*that.denom)

  private def norm(a: Int, b: Int): Int = if(b == 0) a else norm(b, a % b)

  override def compare(that: Rational): Int = this.numer * that.denom compare this.denom * that.numer

  override def equals(that: scala.Any): Boolean = that != null && that.isInstanceOf[Rational] && 
    this.numer == that.asInstanceOf[Rational].numer && this.denom == that.asInstanceOf[Rational].denom

  override def toString: String = this.numer + "/" + this.denom
}
