package com.example.agent;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Component;

@Component
public class ReviewerAgent {

    private final ChatModel chatModel;

    public ReviewerAgent(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String review(String output) {
        return chatModel
                .call("""
                        You are a strict reviewer.
                        Identify gaps, missing topics, and improvements.
                        Rewrite the output with corrections.
                        """ + output);
    }
}
