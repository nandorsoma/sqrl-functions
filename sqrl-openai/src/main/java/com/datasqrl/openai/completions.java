package com.datasqrl.openai;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@AutoService(ScalarFunction.class)
public class completions extends ScalarFunction {

    private static final Logger logger = LoggerFactory.getLogger(completions.class);

    public String eval(String prompt, String modelName) {
        return eval(prompt, modelName, null, null, null);
    }

    public String eval(String prompt, String modelName, Integer maxOutputTokens) {
        return eval(prompt, modelName, maxOutputTokens, null, null);
    }

    public String eval(String prompt, String modelName, Integer maxOutputTokens, Double temperature) {
        return eval(prompt, modelName, maxOutputTokens, temperature, null);
    }

    public String eval(String prompt, String modelName, Integer maxOutputTokens, Double temperature, Double topP) {
        try {
            return OpenAICompletions.callCompletions(prompt, modelName, false, maxOutputTokens, temperature, topP);
        } catch (IOException e) {
            logger.error("Error occurred when calling OpenAI completions API. Returning null.", e);
            return null;
        }
    }
}
