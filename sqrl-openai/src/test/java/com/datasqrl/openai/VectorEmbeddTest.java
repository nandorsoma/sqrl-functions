package com.datasqrl.openai;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class VectorEmbeddTest {

    @Test
    void testEvalSuccessfulEmbedding() {
        double[] expectedResponse = {0.1, 0.2, 0.3}; // Example embedding response

        try (MockedStatic<OpenAIEmbeddings> mockedEmbeddings = Mockito.mockStatic(OpenAIEmbeddings.class)) {
            mockedEmbeddings.when(() -> OpenAIEmbeddings.vectorEmbedd(
                            anyString(), anyString()))
                    .thenReturn(expectedResponse);

            vector_embedd function = new vector_embedd();
            double[] result = function.eval("some text", "model-name");

            assertArrayEquals(expectedResponse, result);
        }
    }

    @Test
    void testEvalErrorHandling() {
        // Mock the static method to throw IOException
        try (MockedStatic<OpenAIEmbeddings> mockedEmbeddings = Mockito.mockStatic(OpenAIEmbeddings.class)) {
            mockedEmbeddings.when(() -> OpenAIEmbeddings.vectorEmbedd(
                            anyString(), anyString()))
                    .thenThrow(new IOException("Test Exception"));

            vector_embedd function = new vector_embedd();
            double[] result = function.eval("some text", "model-name");

            // Check that an empty array is returned
            assertArrayEquals(new double[0], result);
        }
    }
}