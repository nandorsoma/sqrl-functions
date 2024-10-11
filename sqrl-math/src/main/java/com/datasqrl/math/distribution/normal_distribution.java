package com.datasqrl.math.distribution;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates the cumulative distribution function for a normal distribution. */
@AutoService(ScalarFunction.class)
public class normal_distribution extends ScalarFunction {
    public Double eval(Double mean, Double sd, Double x) {
        if (mean == null || sd == null || x == null) return null;
        org.apache.commons.math3.distribution.NormalDistribution dist = new org.apache.commons.math3.distribution.NormalDistribution(mean, sd);
        return dist.cumulativeProbability(x);
    }
}