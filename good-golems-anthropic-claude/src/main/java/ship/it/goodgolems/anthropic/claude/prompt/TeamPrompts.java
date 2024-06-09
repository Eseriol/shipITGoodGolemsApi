package ship.it.goodgolems.anthropic.claude.prompt;

import org.springframework.ai.chat.prompt.PromptTemplate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
}
