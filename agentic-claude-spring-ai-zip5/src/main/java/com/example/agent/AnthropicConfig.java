package com.example.agent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.ai.anthropic.api.AnthropicApi;
import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.anthropic.AnthropicChatOptions;
import org.springframework.ai.chat.model.ChatModel;

@Configuration
public class AnthropicConfig {

    @Value("${spring.ai.anthropic.api-key}")
    private String apiKey;

    @Bean
    public AnthropicApi anthropicApi() {
        // Read API key from environment variable
     //   String apiKey = System.getenv("ANTHROPIC_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                "ANTHROPIC_API_KEY environment variable is not set"
            );
        }

        return new AnthropicApi(apiKey);
    }

    @Bean
    public ChatModel chatModel(AnthropicApi anthropicApi) {

        AnthropicChatOptions options = AnthropicChatOptions.builder()
                .withModel("claude-3-haiku-20240307")
                .withTemperature(0.7)
                .withMaxTokens(1024)
                .build();

        return new AnthropicChatModel(anthropicApi, options);
    }
}
