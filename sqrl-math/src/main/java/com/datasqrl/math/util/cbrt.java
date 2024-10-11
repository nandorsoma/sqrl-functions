package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Returns the cube root of x. */
@AutoService(ScalarFunction.class)
public class cbrt extends ScalarFunction {
    public Double eval(Double x) {
        return x == null ? null : FastMath.cbrt(x);
    }
}