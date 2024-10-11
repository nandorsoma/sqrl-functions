# SQRL Mathematical Functions

The `datasqrl.math` package provides a collection of advanced mathematical functions for use within the SQRL framework.

## Functions Overview

You can use these UDFs in your SQRL scripts to perform advanced mathematical and statistical computations.

| **Function Name**                   | **Description**                                                                                                                                                         |
|-------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **cbrt(double)**                    | Calculates the cube root of a number. For example, `cbrt(27.0)` returns `3.0`, which is the cube root of 27.0.                                                          |
| **copy_sign(double, double)**       | Returns the first argument with the sign of the second argument. For example, `copy_sign(2.0, -3.0)` returns `-2.0`.                                                    |
| **expm1(double)**                   | Calculates e^x - 1 with better precision for small values. For example, `expm1(0.0)` returns `0.0`, as `e^0 - 1 = 0`.                                                   |
| **hypot(double, double)**           | Computes sqrt(x² + y²) without intermediate overflow or underflow. For example, `hypot(3.0, 4.0)` returns `5.0`, which is the hypotenuse of a 3-4-5 triangle.            |
| **log1p(double)**                   | Computes the natural logarithm of 1 + x (log(1 + x)) accurately for small x. For example, `log1p(0.0)` returns `0.0` as `log(1 + 0) = 0`.                              |
| **next_after(double, double)**      | Returns the next floating-point number towards the direction of the second argument. For example, `next_after(1.0, 2.0)` returns the next representable number after 1.0. |
| **scalb(double, bigint)**           | Multiplies a floating-point number by 2 raised to the power of an integer. For example, `scalb(1.0, 3)` returns `8.0` as `1.0 * 2^3 = 8.0`.                             |
| **ulp(double)**                     | Returns the size of the unit in the last place (ULP) of the argument. For example, `ulp(1.0)` returns the ULP of 1.0.                                                   |
| **binomial_distribution(bigint, double, bigint)** | Calculates the probability of obtaining a number of successes in a fixed number of trials for a binomial distribution. For example, `binomial_distribution(10, 0.5, 5)` returns the probability of 5 successes out of 10 trials with a 50% success rate. |
| **exponential_distribution(double, double)** | Evaluates the probability density or cumulative distribution of an exponential distribution. For example, `exponential_distribution(1.0, 2.0)` returns the exponential distribution's probability for a given rate and time. |
| **normal_distribution(double, double, double)** | Evaluates the cumulative distribution function for a normal (Gaussian) distribution. For example, `normal_distribution(0.0, 1.0, 1.0)` returns the probability for a standard normal distribution with mean 0 and standard deviation 1. |
| **poisson_distribution(double, bigint)** | Evaluates the probability mass function of a Poisson-distributed random variable. For example, `poisson_distribution(1.0, 5)` returns the probability of observing 5 events when the average event rate is 1.0. |

## Usage

The `cbrt` function computes the cube root of a given number. It can be useful in mathematical and scientific calculations where you need to find the value that, when cubed, results in the original number.

For example, `cbrt(27)` will return `3`, as \(3^3 = 27\).

### SQRL Example

```sql
IMPORT schema.entry;
IMPORT datasqrl.math.*;

-- This query calculates the cube root for a set of values from the entry table
result_table := 
    SELECT 
        cbrt(d) AS cube_root 
    FROM 
        entry;

-- Displaying the result
SELECT * FROM result_table;
```

## Compile and Test Manually

### Step 1: Build the Project
Ensure that all dependencies are present by running the following Maven package command:
```bash
mvn package
```

### Step 2: Run Your SQRL Script

After the build is complete, make sure to uncomment any required functions or packages in the `math.sqrl` file.
Then, run your SQRL script along with the schema using the following Docker command:
```bash
docker run -i -p 8888:8888 -p 8081:8081 --rm -v $PWD:/build datasqrl/cmd:v0.5.6 run math.sqrl schema.graphqls
```

### Step 3: Test via GraphQL

Open http://localhost:8888/graphiql/ in your browser and execute the following mutation to insert data:
```graphql
mutation {
    data(input: {
        d: 1,
        b:, 1
    }) {
        d
        b
    }
}
```

### Step 4: Retrieve the Results

To view the results, execute the following query:
```graphql
{
    math_results {
        d
        b
        cbrt
        copy_sign
        expm1
        hypot
        log1p
        next_after
        scalb
        ulp
        binomial_distribution
        exponential_distribution
        normal_distribution
        poisson_distribution
    }
}
```