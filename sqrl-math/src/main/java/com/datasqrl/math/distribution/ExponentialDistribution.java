package com.datasqrl.math.distribution;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates the cumulative probability for an exponential distribution. */
@AutoService(ScalarFunction.class)
public class ExponentialDistribution extends ScalarFunction {
    public Double eval(Double mean, Double x) {
        if (mean == null || x == null) return null;
        org.apache.commons.math3.distribution.ExponentialDistribution dist = new org.apache.commons.math3.distribution.ExponentialDistribution(mean);
        return dist.cumulativeProbability(x);
    }
}