package com.datasqrl.math.distribution;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates the probability mass function for a binomial distribution. */
@AutoService(ScalarFunction.class)
public class BinomialDistribution extends ScalarFunction {
    public Double eval(Integer trials, Double probability, Integer x) {
        if (trials == null || probability == null || x == null) return null;
        org.apache.commons.math3.distribution.BinomialDistribution dist = new org.apache.commons.math3.distribution.BinomialDistribution(trials, probability);
        return dist.probability(x);
    }
}