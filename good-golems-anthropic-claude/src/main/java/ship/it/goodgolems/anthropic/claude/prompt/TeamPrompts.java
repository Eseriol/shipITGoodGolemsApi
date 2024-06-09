package ship.it.goodgolems.anthropic.claude.prompt;

import org.springframework.ai.chat.prompt.PromptTemplate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The TeamPrompts class provides prompt templates for selecting the best team based on project requirements.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamPrompts {

    /**
     * Prompt template with using RAG context
     */
    public static final PromptTemplate ADVISE_TEAM = new PromptTemplate("""
            Based on the list of available employees and the project requirements select the best team.
            The project requirement: {project}
            """);

    /**
     * Prompt template without RAG
     */
    public static final PromptTemplate SUGGEST_TEAM = new PromptTemplate("""
            Based on the list of employees and the project requirements select the best team.
            The project requirement: {project}
            List of employees: {employees}
            """);

    public static final PromptTemplate EXPLAIN_SUGGESTION = new PromptTemplate("""
            Based on the list of employees and the project requirements explain why these teammates are the best for this project.
            The project requirement: {project}
            List of employees: {employees}
            """);
}
