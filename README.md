# wls-scala

weighted linear regression in pure Scala w/o any 3d party dependency or framework e.g. spark & the like.

the idea is similar to [statsmodels.regression.linear_model.WLS.fit](https://tinyurl.com/y3vkn5d2)

## General Info

WLS is based on the OLS method and help solve problems of model inadequacy or violations of the basic regression
assumptions.

## How-to

```scala
package org.vspaz.wls

val xPoints: Array[Double] = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)
val yPoints: Array[Double] = Array(1.0, 3.0, 4.0, 5.0, 2.0, 3.0, 4.0)
val weights: Array[Double] = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)

val point = new Wls(xPoints, yPoints, weights).fitLinearRegression().get
val intercept = point.intercept
val slope = point.slope
```

## References

- [Wikipedia: Weighted least squares](https://en.wikipedia.org/wiki/Weighted_least_squares)
- [Introduction to Linear Regression Analysis, 5th edition](https://tinyurl.com/y3clfnrs)
- [Least Squares Regression Analysis in Terms of Linear Algebra](https://tinyurl.com/y485qhlg) 

