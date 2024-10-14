package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Returns the next floating-point number. */
@AutoService(ScalarFunction.class)
public class next_after extends ScalarFunction {
    public Double eval(Double start, Double direction) {
        if (start == null || direction == null) return null;
        return FastMath.nextAfter(start, direction);
    }
}