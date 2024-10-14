package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Returns the unit in the last place of x. */
@AutoService(ScalarFunction.class)
public class ulp extends ScalarFunction {
    public Double eval(Double x) {
        return x == null ? null : FastMath.ulp(x);
    }
}