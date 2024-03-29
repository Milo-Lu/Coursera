package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println(balance(":-)".toList))
    print(countChange(4, List(1,2)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if(c==0 || r==0 || c==r) 1 else pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean =
      if(chars.length==1 && (chars(0)=='(' || chars(0)==')')) false
      else if(chars.head!='(') balance(chars.tail)
      else if(chars.last!=')') balance(chars.init)
      else true
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int =
      if(money<0) 0
      else if(money==0) 1
      else if(money>0 && coins.isEmpty) 0
      else countChange(money, coins.tail) + countChange(money-coins.head, coins)
  }
