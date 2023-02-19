package org.vspaz

import org.vspaz.wls.Wls

object Main {
  def main(args: Array[String]): Unit = {
    val x: Array[Double] = Array(1, 2, 3, 4, 5, 6, 7)
    val y: Array[Double] = Array(1, 3, 4, 5, 2, 3, 4)
    val point = new Wls(x, y, 0.9).fitLinearRegression().get
    println(point.intercept)
    println(point.slope)
  }
}