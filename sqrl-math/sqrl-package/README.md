# SQRL Mathematical Functions

The `com.datasqrl.math` package provides a collection of advanced mathematical functions for use within the SQRL framework.

## Functions Overview

To use these functions, simply import the necessary classes and call the desired function in your SQL queries within
the SQRL framework.

### Cbrt
**Calculates the cube root of a given value.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Cbrt;

MyTable := SELECT val, Cbrt(val) AS croot FROM Entry;
```

### Atan2
**Computes the arc tangent of the quotient of its arguments.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Atan2;

MyTable := SELECT x, y, Atan2(y, x) AS angle FROM Entry;
```

### Copysign
**Returns the first argument with the sign of the second argument.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Copysign;

MyTable := SELECT val1, val2, Copysign(val1, val2) AS cps FROM Entry;
```

### Hypot
**Calculates the hypotenuse of a right triangle without overflow.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Hypot;

MyTable := SELECT x, y, Hypot(x, y) AS hypotenuse FROM Entry;
```

### Max
**Returns the maximum of two values**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Max;

MyTable := SELECT val1, val2, Max(val1, val2) AS maximum FROM Entry;
```

### Min
**Returns the minimum of two values.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Min;

MyTable := SELECT val1, val2, Min(val1, val2) AS minimum FROM Entry;
```

### ULP
**Returns the distance between this number and the next representable floating point value.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Ulp;

MyTable := SELECT val, Ulp(val) AS ulpDistance FROM Entry;
```

### ExpM1
**Calculates e^x - 1 with better precision for small values.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Expm1;

MyTable := SELECT val, Expm1(val) AS result FROM Entry;
```

### Log1P
**Calculates the natural logarithm of 1 + x with better precision for small x.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.Log1p;

MyTable := SELECT val, Log1p(val) AS result FROM Entry;
```

### NextAfter
**Returns the next representable floating point value after a given value in the specified direction.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.NextAfter;

MyTable := SELECT val, NextAfter(val, targetVal) AS nextValue FROM Entry;
```

### BinomialDist
**Calculates the probability mass function for a binomial distribution.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.BinomialDist;

MyTable := SELECT n, k, BinomialDist(n, k, p) AS probability FROM Entry;
```

### PoissonDist
**Calculates the probability mass function for a Poisson distribution.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.PoissonDist;

MyTable := SELECT lambda, x, PoissonDist(lambda, x) AS probability FROM Entry;
```

### ExponentialDist
**Calculates the probability density function for an exponential distribution.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.ExponentialDist;

MyTable := SELECT lambda, x, ExponentialDist(lambda, x) AS probability FROM Entry;
```

### NormalDist
**Calculates the cumulative distribution function for a normal distribution.**

```sql
IMPORT myudf.Entry;
IMPORT datasqrl.functions.math.NormalDist;

MyTable := SELECT mean, stddev, x, NormalDist(mean, stddev, x) AS probability FROM Entry;
```
