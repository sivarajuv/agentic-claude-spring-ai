package com.example.agent;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Component;

@Component
public class PlannerAgent {

    private final ChatModel chatModel;

    public PlannerAgent(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String plan(String goal) {
        return chatModel.call("""
                You are a planner.
                Output ONLY a numbered list of steps.
                No explanations.
                Goal: %s
                """.formatted(goal));
    }
}
