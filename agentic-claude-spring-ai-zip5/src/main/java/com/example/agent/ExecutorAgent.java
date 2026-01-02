package com.example.agent;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Component;

@Component
public class ExecutorAgent {

    private final ChatModel chatModel;

    public ExecutorAgent(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String execute(String plan) {
        return chatModel.call("""
                You are an executor.
                Follow the steps EXACTLY.
                Do not add new steps.
                Steps:
                %s
                """.formatted(plan));
    }
}
