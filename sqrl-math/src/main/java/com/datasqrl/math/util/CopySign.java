package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Returns the first argument with the sign of the second. */
@AutoService(ScalarFunction.class)
public class CopySign extends ScalarFunction {
    public Double eval(Double magnitude, Double sign) {
        if (magnitude == null || sign == null) return null;
        return FastMath.copySign(magnitude, sign);
    }
}