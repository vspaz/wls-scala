package wls

import org.junit.jupiter.api.Assertions.assertEquals
import org.scalatest.funsuite.AnyFunSuite

class WlsTest extends AnyFunSuite {

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
}
