package common

import scala.util.Random

object Helper {
  type Matrix = IndexedSeq[IndexedSeq[Double]]
  def genMatrix(rows:Int,cols:Int,max:Int):Matrix =
    for (_ <- 1 to rows) yield for (_ <- 1 to cols) yield Random.nextInt(max).toDouble
  def printMatrix(matrix:Matrix) = matrix.map(x=> f"[${x.mkString("\t")}]").mkString("\n")

  def printVariant(): Unit ={
    println("""
Лабораторна робота 1 з МОПЕ
Варіант: 301
Виконав: [IO-93] Бернадін Олександр Володимирович
Перевірив: Регіда П.Г
""")
  }
}
