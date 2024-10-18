package com.datasqrl.openai;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableResult;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class VectorEmbeddFlinkSqlTest {

    private StreamTableEnvironment tEnv;
    private vector_embedd function;

    @BeforeEach
    public void setUp() {
        // Set up Flink Stream and Table environments
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings settings = EnvironmentSettings.newInstance().inStreamingMode().build();
        tEnv = StreamTableEnvironment.create(env, settings);

        // Create an instance of the function to register with the environment
        function = new vector_embedd();

        // Register the function in the Flink SQL environment
        tEnv.createTemporarySystemFunction("vector_embedd", function);
    }

    @Test
    public void testVectorEmbeddFunctionWithSQL() {
        // Use static mocking for the vectorEmbedd method in OpenAIEmbeddings
        try (MockedStatic<OpenAIEmbeddings> mockedEmbeddings = Mockito.mockStatic(OpenAIEmbeddings.class)) {
            // Define the mocked response for the static method call
            Double[] expectedResponse = {0.1, 0.2, 0.3}; // Use boxed type
            mockedEmbeddings.when(() -> OpenAIEmbeddings.vectorEmbedd(
                    Mockito.anyString(),
                    Mockito.anyString()
            )).thenReturn(new double[]{0.1, 0.2, 0.3}); // Returning primitive double array

            // Execute SQL that uses the vector_embedd function
            TableResult result = tEnv.executeSql(
                    "SELECT vector_embedd('Test text', 'model-name') AS embedding_result"
            );

            // Collect and verify the result
            result.collect().forEachRemaining(row -> {
                Double[] embeddingOutput = (Double[]) row.getField("embedding_result"); // Use boxed type
                // Convert to double array for comparison
                double[] doubleArrayOutput = new double[embeddingOutput.length];
                for (int i = 0; i < embeddingOutput.length; i++) {
                    doubleArrayOutput[i] = embeddingOutput[i]; // Unboxing
                }
                assertArrayEquals(new double[]{0.1, 0.2, 0.3}, doubleArrayOutput); // Compare primitive arrays
            });
        }
    }

    @Test
    public void testVectorEmbeddFunctionWithSQLAndDefaults() {
        // Use static mocking for the vectorEmbedd method in OpenAIEmbeddings
        try (MockedStatic<OpenAIEmbeddings> mockedEmbeddings = Mockito.mockStatic(OpenAIEmbeddings.class)) {
            // Define the mocked response for the static method call
            double[] expectedResponse = {0.4, 0.5, 0.6}; // Use boxed type
            mockedEmbeddings.when(() -> OpenAIEmbeddings.vectorEmbedd(
                    Mockito.anyString(),
                    Mockito.anyString()
            )).thenReturn(expectedResponse); // Returning primitive double array

            // Execute SQL that uses the vector_embedd function with defaults
            TableResult result = tEnv.executeSql(
                    "SELECT vector_embedd('Another test text', 'model-name') AS embedding_result"
            );

            // Collect and verify the result
            result.collect().forEachRemaining(row -> {
                Double[] embeddingOutput = (Double[]) row.getField("embedding_result"); // Use boxed type
                // Convert to double array for comparison
                double[] doubleArrayOutput = new double[embeddingOutput.length];
                for (int i = 0; i < embeddingOutput.length; i++) {
                    doubleArrayOutput[i] = embeddingOutput[i]; // Unboxing
                }
                assertArrayEquals(new double[]{0.4, 0.5, 0.6}, doubleArrayOutput); // Compare primitive arrays
            });
        }
    }
}