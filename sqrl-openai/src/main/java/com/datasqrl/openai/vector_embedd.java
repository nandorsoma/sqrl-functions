package com.datasqrl.openai;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@AutoService(ScalarFunction.class)
public class vector_embedd extends ScalarFunction {
    private static final Logger logger = LoggerFactory.getLogger(vector_embedd.class);

    public double[] eval(String text, String modelName) {
        try {
            return OpenAIEmbeddings.vectorEmbedd(text, modelName);
        } catch (IOException e) {
            logger.error("Error occurred when calling OpenAI embeddings API. Returning an empty array.", e);
            return new double[0];
        }
    }
}
