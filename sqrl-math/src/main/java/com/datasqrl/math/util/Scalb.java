package com.datasqrl.math.util;

import com.google.auto.service.AutoService;
import org.apache.commons.math3.util.FastMath;
import org.apache.flink.table.functions.ScalarFunction;

/** Multiplies x by 2^scaleFactor. */
@AutoService(ScalarFunction.class)
public class Scalb extends ScalarFunction {
    public Double eval(Double x, Integer scaleFactor) {
        if (x == null || scaleFactor == null) return null;
        return FastMath.scalb(x, scaleFactor);
    }
}