package com.example.agent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    private final OrchestratorAgent orchestrator;

    public AgentController(OrchestratorAgent orchestrator) {
        this.orchestrator = orchestrator;
    }

    @GetMapping("/agent/run")
    public String run(@RequestParam String goal) {
        return orchestrator.run(goal);
    }
}
