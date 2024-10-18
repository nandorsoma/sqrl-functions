package com.datasqrl.openai;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class CompletionsTest {

    @Test
    void testEvalSuccessfulCompletion() {
        String expectedResponse = "{\"key\": \"completion_value\"}";

        try (MockedStatic<OpenAICompletions> mockedCompletions = Mockito.mockStatic(OpenAICompletions.class)) {
            mockedCompletions.when(() -> OpenAICompletions.callCompletions(
                            anyString(), anyString(), eq(false), anyInt(), anyDouble(), anyDouble()))
                    .thenReturn(expectedResponse);

            completions function = new completions();
            String result = function.eval("prompt", "model", 100, 0.7, 0.9);

            assertEquals(expectedResponse, result);
        }
    }

    @Test
    void testEvalWithDefaults() {
        String expectedResponse = "{\"key\": \"completion_default\"}";

        try (MockedStatic<OpenAICompletions> mockedCompletions = Mockito.mockStatic(OpenAICompletions.class)) {
            mockedCompletions.when(() -> OpenAICompletions.callCompletions(
                            anyString(), anyString(), eq(false), isNull(), isNull(), isNull()))
                    .thenReturn(expectedResponse);

            completions function = new completions();
            String result = function.eval("prompt", "model");

            assertEquals(expectedResponse, result);
        }
    }

    @Test
    void testEvalErrorHandling() {
        try (MockedStatic<OpenAICompletions> mockedCompletions = Mockito.mockStatic(OpenAICompletions.class)) {
            mockedCompletions.when(() -> OpenAICompletions.callCompletions(
                            anyString(), anyString(), eq(false), anyInt(), anyDouble(), anyDouble()))
                    .thenThrow(new IOException("Test Exception"));

            completions function = new completions();
            String result = function.eval("prompt", "model", 100, 0.7, 0.9);

            assertNull(result);
        }
    }
}
