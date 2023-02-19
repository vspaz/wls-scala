package org.vspaz.wls

class Wls(val xPoints: Array[Double], val yPoints: Array[Double], val weights: Array[Double]) {
  assert(xPoints.length == yPoints.length)
  assert(xPoints.length == weights.length)
  assert(xPoints.length >= 2)
  def this(xPoints: Array[Double], yPoints: Array[Double], weight: Double) = {
    this(xPoints, yPoints, Array.fill(xPoints.length)(weight))
  }

  def this(xPoints: Array[Double], yPoints: Array[Double]) = {
    this(xPoints, yPoints, 1.0)
  }

  def fitLinearRegression(): Option[Point] = {
    var sumOfWeights = 0.0
    var sumOfWeightsByXSquared = 0.0
    var sumOfXByYByWeights = 0.0
    var sumOfXByWeights = 0.0
    var sumOfYByWeights = 0.0

    var Xi = 0.0
    var Yi = 0.0
    var Wi = 0.0
    var XiByWi = 0.0

    for (i <- this.xPoints.indices) {
      Xi = this.xPoints(i)
      Yi = this.yPoints(i)
      Wi = this.weights(i)
      sumOfWeights += Wi
      XiByWi = Xi * Wi
      sumOfXByWeights += XiByWi
      sumOfXByYByWeights += XiByWi * Yi
      sumOfYByWeights += Yi * Wi
      sumOfWeightsByXSquared += XiByWi * Xi
    }

    val dividend = sumOfWeights * sumOfXByYByWeights - sumOfXByWeights * sumOfYByWeights
    val divisor = sumOfWeights * sumOfWeightsByXSquared - sumOfXByWeights * sumOfXByWeights

    if (divisor == 0)
      return None

    val slope = dividend / divisor
    val intercept = (sumOfYByWeights - slope * sumOfXByWeights) / sumOfWeights

    Option(new Point(intercept, slope))
  }
}
