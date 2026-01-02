package com.example.agent;

import org.springframework.stereotype.Component;

@Component
public class OrchestratorAgent {

    private final PlannerAgent planner;
    private final ExecutorAgent executor;
    private final ReviewerAgent reviewer;

    public OrchestratorAgent(
            PlannerAgent planner,
            ExecutorAgent executor,
            ReviewerAgent reviewer
    ) {
        this.planner = planner;
        this.executor = executor;
        this.reviewer = reviewer;
    }

    public String run(String goal) {
        String plan = planner.plan(goal);
        String result = executor.execute(plan);
        return reviewer.review(result);
    }
}
