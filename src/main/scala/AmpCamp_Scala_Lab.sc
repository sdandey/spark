val myNumbers = List(1,3,5,3,4)
val x = 2
1 + (2 * 3) / x
1 + 2 * 3 / x
(1).+(20)


def cube(a: Int): Int = a * a * a
def square(a: Int): Int = a * a
cube(3)
square(cube(3))
val squareRoot = myNumbers.map(a => a * a)
myNumbers
squareRoot
def factorial(a: Int): Int = {
  if(a == 0){
     1;
  }
  else
  return a * factorial(a-1)
}
factorial(10)
def fact(n: BigDecimal): BigDecimal = if (n == 0 ) 1 else n * fact(n-1)
fact(50)
fact(5)
fact(10)
val upper: String => String = _.toUpperCase
upper("Santosh Dandey")

val lower: String => String = _.toLowerCase().trim
lower("SANTOSH ")

















