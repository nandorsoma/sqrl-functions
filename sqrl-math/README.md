# SQRL Mathematical Functions

The `com.datasqrl.math` package provides a collection of advanced mathematical functions for use within the SQRL framework.

## Compile and Run

First, ensure that all dependencies are installed by running the Maven package command:
```bash
mvn package
```

Once the build is complete, compile your SQRL script along with the schema:
```bash
sqrl compile math.sqrl schema.graphqls
```

Start the containers with:
```bash
docker compose up --build
```

## Functions Overview

Each function operates on DOUBLE (denoted as d) and BIGINT (denoted as b) in the examples.
You can use these UDFs in your SQRL scripts to perform advanced mathematical and statistical computations.

### Atan2

**Computes the arc tangent of y/x in a way that preserves the quadrant.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Atan2(d, d) AS atan2 FROM Entry;
```

### Cbrt

**Calculates the cube root of a number.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Cbrt(d) AS cbrt FROM Entry;
```

### CopySign

**Returns the first argument with the sign of the second argument.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT CopySign(d, d) AS copySign FROM Entry;
```

### Expm1

**Calculates e^x - 1 with better precision for small values.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Expm1(d) AS expm1 FROM Entry;
```

### Hypot

**Computes sqrt(x² + y²) without intermediate overflow or underflow.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Hypot(d, d) AS hypot FROM Entry;
```

### Log1p

**Computes the natural logarithm of 1 + x (log(1 + x)) accurately for small x.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Log1p(d) AS log1p FROM Entry;
```

### NextAfter

**Returns the next floating-point number towards the direction of the second argument.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT NextAfter(d, d) AS nextAfter FROM Entry;
```

### Scalb

**Multiplies a floating-point number by 2 raised to the power of an integer.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Scalb(d, b) AS scalb FROM Entry;
```

### Ulp

**Returns the size of the unit in the last place (ULP) of the argument.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT Ulp(d) AS ulp FROM Entry;
```

### BinomialDistribution

**Calculates the probability of obtaining a number of successes in a fixed number of trials for a binomial distribution.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT BinomialDistribution(b, d, b) AS binomial FROM Entry;
```

### ExponentialDistribution

**Evaluates the probability density or cumulative distribution of an exponential distribution.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT ExponentialDistribution(d, d) AS exponential FROM Entry;
```

### NormalDistribution

**Evaluates the cumulative distribution function for a normal (Gaussian) distribution.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT NormalDistribution(d, d, d) AS normal FROM Entry;
```

### PoissonDistribution

**Evaluates the probability mass function of a Poisson-distributed random variable.**

```sql
IMPORT schema.Entry;
IMPORT datasqrl.functions.math.*;

MyTable := SELECT PoissonDistribution(d, b) AS poisson FROM Entry;
```
