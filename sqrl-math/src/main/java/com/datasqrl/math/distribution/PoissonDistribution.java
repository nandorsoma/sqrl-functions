package com.datasqrl.math.distribution;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates the cumulative probability for a Poisson distribution. */
@AutoService(ScalarFunction.class)
public class PoissonDistribution extends ScalarFunction {
    public Double eval(Double mean, Integer x) {
        if (mean == null || x == null) return null;
        org.apache.commons.math3.distribution.PoissonDistribution dist = new org.apache.commons.math3.distribution.PoissonDistribution(mean);
        return dist.cumulativeProbability(x);
    }
}