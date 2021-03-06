package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    1.+(2)
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if ((c == 0) || (c == r)) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def isParanthesesbalanced(chars: List[Char], numberOfOpens: Int): Boolean = {
      if (chars.isEmpty) numberOfOpens == 0
      else if (chars.head == '(')
        isParanthesesbalanced(chars.tail, numberOfOpens + 1)
      else if (chars.head == ')')
        numberOfOpens > 0 && isParanthesesbalanced(chars.tail, numberOfOpens - 1)
      else isParanthesesbalanced(chars.tail, numberOfOpens)
    }
    isParanthesesbalanced(chars, 0)
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChange(money:Int, coins: List[Int], count:Int): Int = {
      if (money < 0) count
      else
        if (coins.isEmpty)
          if (money == 0) count + 1 else count
        else
          countChange(money - coins.head, coins, count) + countChange(money, coins.tail, count)
    }
    countChange(money, coins, 0)
  }
}
