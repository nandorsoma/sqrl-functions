package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Computes the arc tangent of y/x in a way that preserves the quadrant. */
@AutoService(ScalarFunction.class)
public class Atan2 extends ScalarFunction {
    public Double eval(Double y, Double x) {
        if (y == null || x == null) return null;
        return FastMath.atan2(y, x);
    }
}