Agentic AI with Spring Boot & Spring AI (Anthropic)

This project demonstrates how to build an Agentic AI system using Spring Boot and Spring AI (Anthropic / Claude).

Instead of a single LLM call, the system uses multiple specialized agents to plan, execute, and review a task — similar to how real teams work.

🧠 One-Shot vs Agentic

One-shot LLM

User → LLM → Answer


Agentic AI (this project)

User
↓
Planner Agent   → creates a plan
↓
Executor Agent  → executes the plan
↓
Reviewer Agent  → improves the result

🎯 Example

Goal

Learn Spring Boot in 30 days


Each agent handles a specific responsibility, producing a more structured and refined result than a normal chat response.

🧩 Key Components

PlannerAgent – breaks down the goal

ExecutorAgent – executes the plan

ReviewerAgent – reviews and improves output

OrchestratorAgent – coordinates agents

AgentController – REST API entry point

⚙️ Tech Stack

Java 17

Spring Boot 3.2.x

Spring AI (Anthropic – Claude)

Maven

🔐 Configuration (application.yml)
spring:
ai:
anthropic:
api-key: YOUR_ANTHROPIC_API_KEY
chat:
model: claude-3-haiku-20240307
max-tokens: 1024

▶️ Run the Application
mvn clean spring-boot:run

🌐 API
GET http://localhost:8080/agent/run?goal=learn spring boot in 30 days

🚀 Why Agentic AI?
Feature	One-Shot Chat	Agentic
Planning	❌	✅
Review	❌	✅
Control	Low	High
Enterprise-ready	❌	✅
📌 Key Takeaway

Chat models answer questions.
Agentic systems perform work.

This project is a foundation for building real-world AI agents using Spring Boot.
