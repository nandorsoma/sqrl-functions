package com.datasqrl.math.distribution;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates the probability mass function for a binomial distribution. */
@AutoService(ScalarFunction.class)
public class binomial_distribution extends ScalarFunction {
    public Double eval(Long trials, Double probability, Long x) {
        if (trials == null || probability == null || x == null) return null;
        org.apache.commons.math3.distribution.BinomialDistribution dist = new org.apache.commons.math3.distribution.BinomialDistribution(trials.intValue(), probability);
        return dist.probability(x.intValue());
    }
}