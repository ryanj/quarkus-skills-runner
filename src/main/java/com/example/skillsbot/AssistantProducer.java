package com.example.skillsbot;

import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import dev.langchain4j.skills.shell.ShellSkills;
//import dev.langchain4j.skills.FileSystemSkillLoader;
//import java.nio.file.Path;
//import dev.langchain4j.memory.chat.MessageWindowChatMemory;

@ApplicationScoped
public class AssistantProducer {

    @Produces
    public Assistant assistant() {

        // Register skills from the .skills folder:
        //ShellSkills skills = ShellSkills.from(FileSystemSkillLoader.loadSkills(Path.of(".skills/skills/")));

        return AiServices.builder(Assistant.class)
                   .tools(new ExtraTools())
                   .build();
                   //.systemMessageProvider(SkillsSystemMessageProvider.class)
                   //.toolProvider(skills.toolProvider())
                   //.chatMemory(MessageWindowChatMemory.withMaxMessages(10))
    }
}
