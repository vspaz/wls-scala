package wls

class Wls(val xPoints: Array[Double], val yPoints: Array[Double], val weights: Array[Double]) {
  def this(xPoints: Array[Double], yPoints: Array[Double], weight: Double) =
    this(xPoints, yPoints, Array.fill(xPoints.length)(weight))
  def this(xPoints: Array[Double], yPoints: Array[Double]) =
    this(xPoints, yPoints, 1)
}
