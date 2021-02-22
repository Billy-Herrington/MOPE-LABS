package lab1
import common.Helper
import common.Helper.Matrix

object Lab1Starter {
  def main(array: Array[String]) {
    Helper.printVariant()
    val neDishutePlzTimer = System.currentTimeMillis()
    val (a0, a1, a2, a3) = (1, 5, 9, 15)
    val xMatrix:Matrix = Helper.genMatrix(8,3,21)
    val transMatrix:Matrix=xMatrix.map(tp=>List(tp.head,tp(1),tp(2))).transpose
    val xSortedArr = transMatrix.map(x=>x.sorted)
    val xAvgArr = xSortedArr.map(x =>(x.head+x.last)/2)
    val maxValuesOfColumn = transMatrix.map(x=>x.max)
    val xdxArr = for (i <- 0 to 2) yield {maxValuesOfColumn(i) - xAvgArr(i)}
    val yArr = for (i <- 0 to 7) yield {
      a0 + a1*xMatrix(i)(0)+a2*xMatrix(i)(1)+a3*xMatrix(i)(2)
    }
    val yAvg = yArr.sum/yArr.size
    val xNMatrix:Matrix = for (row <- 0 to 7) yield for (col <- 0 to 2)
      yield ((xMatrix(row)(col) - xAvgArr(col))/xdxArr(col))
    val yAnswerArray = yArr.map(_ - yAvg)
    val answer = yAnswerArray.filter(_ > 0).min
    val index = yAnswerArray.indexOf(answer)
    val neDishutePlzTimerEnd = System.currentTimeMillis()
    println(s"X MATRIX :\n${Helper.printMatrix(xMatrix)}")
    println(f"Y VALUES = ${yArr}")
    println(f"X0 VALUES = ${xAvgArr}")
    println(f"xdx VALUES = ${xdxArr}")
    println(f"Xn Matrix = \n${Helper.printMatrix(xNMatrix)}")
    println(f"AVG(Y) = ${yAvg}")
    println(f"AVG(Y) ← = ${answer}")
    println(f"ROW OF ANSWER = \n[${xMatrix(index).mkString("\t")}]")
    println(f"EXECUTION TIME = ${neDishutePlzTimerEnd-neDishutePlzTimer}")

  }
}
