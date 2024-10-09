package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates e^x - 1  with better precision for small values. */
@AutoService(ScalarFunction.class)
public class Expm1 extends ScalarFunction {
    public Double eval(Double x) {
        return x == null ? null : FastMath.expm1(x);
    }
}