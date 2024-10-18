package com.datasqrl.openai;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class ExtractJsonTest {

    @Test
    void testEvalSuccessfulCompletion() {
        // Mock the static method call
        String expectedResponse = "{\"key\": \"value\"}";

        // Prepare for static mocking
        try (MockedStatic<OpenAICompletions> mockedCompletions = Mockito.mockStatic(OpenAICompletions.class)) {
            mockedCompletions.when(() -> OpenAICompletions.callCompletions(anyString(), anyString(), eq(true),
                            any(), anyDouble(), anyDouble()))
                    .thenReturn(expectedResponse);

            extract_json function = new extract_json();
            String result = function.eval("prompt", "model", 0.7, 0.9);

            assertEquals(expectedResponse, result);
        }
    }

    @Test
    void testEvalWithDefaults() {
        String expectedResponse = "{\"key\": \"default\"}";

        try (MockedStatic<OpenAICompletions> mockedCompletions = Mockito.mockStatic(OpenAICompletions.class)) {
            mockedCompletions.when(() -> OpenAICompletions.callCompletions(anyString(), anyString(), eq(true), any(), isNull(), isNull()))
                    .thenReturn(expectedResponse);

            extract_json function = new extract_json();
            String result = function.eval("prompt", "model"); // Calling without optional params

            assertEquals(expectedResponse, result);
        }
    }

    @Test
    void testEvalErrorHandling() {
        // Mock the static method to throw IOException
        try (MockedStatic<OpenAICompletions> mockedCompletions = Mockito.mockStatic(OpenAICompletions.class)) {
            mockedCompletions.when(() -> OpenAICompletions.callCompletions(anyString(), anyString(), eq(true),
                            any(), anyDouble(), anyDouble()))
                    .thenThrow(new IOException("Test Exception"));

            extract_json function = new extract_json();
            String result = function.eval("prompt", "model", 0.7, 0.9);

            assertNull(result);
        }
    }
}