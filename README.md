# quarkus-skills

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Configure:

Export your `OPENAI_API_KEY`:

```shell
export OPENAI_API_KEY="YOUR_OPENAI_API_KEY"
```

Optionally configure a custom `quarkus.langchain4j.openai.base-url` in `src/main/resources/application.properties`.

Optionally update `pom.xml` to enable ollama support.

## Build and Run:

```shell script
./mvnw package && java -jar target/quarkus-app/quarkus-run.jar
```

## Basic SKILL interactions:

To test the `poem-writing` skill, enter the following prompt:
```
/poem-writing
```

Run the `/hello` skill to test a mult-step workflow:
```shell
/hello
```

Conduct a security review of the codebase using the `secdevai` skills (from lola):
```shell
/secdevai review
```
