package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Calculates the hypotenuse of a right-angled triangle without overflow. */
@AutoService(ScalarFunction.class)
public class Hypot extends ScalarFunction {
    public Double eval(Double x, Double y) {
        if (x == null || y == null) return null;
        return FastMath.hypot(x, y);
    }
}
