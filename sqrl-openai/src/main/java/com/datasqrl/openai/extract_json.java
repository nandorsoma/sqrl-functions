package com.datasqrl.openai;

import com.google.auto.service.AutoService;
import org.apache.flink.table.functions.ScalarFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@AutoService(ScalarFunction.class)
public class extract_json extends ScalarFunction {

    private static final Logger logger = LoggerFactory.getLogger(extract_json.class);

    public String eval(String prompt, String modelName) {
        return eval(prompt, modelName, null, null);
    }

    public String eval(String prompt, String modelName, Double temperature) {
        return eval(prompt, modelName, temperature, null);
    }

    public String eval(String prompt, String modelName, Double temperature, Double topP) {
        try {
            return OpenAICompletions.callCompletions(prompt, modelName, true, null, temperature, topP);
        } catch (IOException e) {
            logger.error("Error occurred when calling OpenAI completions API. Returning null.", e);
            return null;
        }
    }
}
