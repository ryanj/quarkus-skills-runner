# Quarkus Skills Runner

Agentic [Skills](https://agentskills.io/) with [Quarkus](https://quarkus.io/) and [LangChain4j](https://docs.quarkiverse.io/quarkus-langchain4j/dev/skills.html)

## Configuration:

Export your `OPENAI_API_KEY`:

```shell
export OPENAI_API_KEY="YOUR_OPENAI_API_KEY"
```

Optionally configure a custom `quarkus.langchain4j.openai.base-url` in `src/main/resources/application.properties`

Optionally enable ollama support in `pom.xml`

## Build and Run:

```shell script
./mvnw package && java -jar target/quarkus-app/quarkus-run.jar
```

## Basic SKILL interactions:

Check to see which skills are available:
```shell
what skills do you have?
```

To test the `poem-writing` skill, enter the following command at the prompt:
```
/poem-writing
```

Additional examples are available in [DEMO.md](https://github.com/ryanj/quarkus-skills-runner/edit/main/DEMO.md)
