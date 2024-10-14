package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Returns log(1 + x) with better precision for small values. */
@AutoService(ScalarFunction.class)
public class log1p extends ScalarFunction {
    public Double eval(Double x) {
        return x == null ? null : FastMath.log1p(x);
    }
}
