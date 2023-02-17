package wls

import org.junit.jupiter.api.Assertions.assertEquals
import org.scalatest.funsuite.AnyFunSuite

class WlsTest extends AnyFunSuite {
  val delta = 1.0e-6

  test("org.vspaz.wls.PointConstructorOk") {
    val point = new Point(intercept = 10, slope = 20)
    assertEquals(10, point.intercept)
    assertEquals(20, point.slope)
  }

  test("org.vspaz.wls.WlsConstructorOk") {
    new Wls(Array(1.0), Array(1.0), 1.0)
    new Wls(Array(1.0), Array(1.0), Array(1.0))
    new Wls(Array(1.0), Array(1.0))
  }

  test("org.vspaz.wls.WlsWithStableWeight") {
    val x: Array[Double] = Array(1, 2, 3, 4, 5, 6, 7)
    val y: Array[Double] = Array(1, 3, 4, 5, 2, 3, 4)
    val point = new Wls(x, y).fitLinearRegression().get
    assertEquals(2.14285714, point.intercept, delta)
    assertEquals(0.25, point.slope, delta)
  }
}