# Quarkus Skills Runner - Demo Script

### Examples

1. Minimal `poem-writing` example:
```
---
name: poem-writing
description: Instructions for writing a poem
---

When asked to write a poem, follow these rules strictly:

1. The poem MUST have exactly 12 lines.
2. The poem MUST be about an optimistic tree.
```
2. Multi-step workflow with resource files:
```
---
name: api-docs
description: Generate comprehensive API documentation
---

Create API documentation that includes:

<Steps>
<Step>
Overview section:
- Purpose and use cases
- Authentication requirements
- Base URL and versioning

</Step>

<Step>
For each endpoint:
- HTTP method and path
- Description and purpose
- Request parameters
- Request body schema
- Response codes and schemas
- Example requests and responses

</Step>

<Step>
Additional sections:
- Error handling
- Rate limiting
- Pagination

</Step>
</Steps>

Follow the template in `api-doc-template.md` and examples in `api-examples.md`.
```
3. Input processing example `roll-dice`:
~~~markdown
---
name: roll-dice
description: Roll dice using a random number generator. Use when asked to roll a die (d6, d20, etc.), roll dice, or generate a random dice roll.
---

To roll a die, use the following command that generates a random number from 1 to the given number of sides:

```bash
echo $((RANDOM % <sides> + 1))
```

```powershell
Get-Random -Minimum 1 -Maximum (<sides> + 1)
```

Replace `<sides>` with the number of sides on the die (e.g., 6 for a standard die, 20 for a d20).
~~~

NOTE: **Security Warning:** Carefully review skills before using or sharing!

Java workflow example:
```
---
name: process-order
description: Processes a customer order end-to-end
---

To process an order:

1. Call `validateOrder(orderId)` to check the order is valid.
2. Call `reserveInventory(orderId)` to reserve the required stock.
3. Only if reservation succeeds, call `chargePayment(orderId)`.
4. Finally, call `sendConfirmationEmail(orderId)`.

If any step fails, call `rollbackOrder(orderId)` before reporting the error.
```

![Remember Little Bobby Tables](https://imgs.xkcd.com/comics/exploits_of_a_mom.png)

## Quarkus Skills Demo

Experiment with Skills using the Skills Runner:
```
mvn package && java -jar target/quarkus-app/quarkus-run.jar
```

Ask the agent about access to tools and skills:
```
What skills and tools do you have access to?
```

Request a poem. The agent should automatically activate relevant skills based on the name and description provided in the initial metadata:
```
Write a poem, please
```

Was the skill used automatically?  If not, ask the agent to use a specific skill by name:
```
Activate the 'poem-writing' skill and use it to compose a new poem
```

Quarkus provides an `activate_skill` tool for loading skill markdown instructions into context:
```
Use tools to call "activate_skill('poem-writing')"
```

Pass a parameter to a skill: "Roll a d12":
```
Use the 'roll-dice' skill to roll a d12
```

Review the 'init-repo' skill (do not copy/paste):
```markdown
---
name: init-repo
description: Initialize the repo with a HELLO.md file
---

Ensure the repo contains a `HELLO.md` file by completing these steps in order:

1. Use `readFile("HELLO.md")` to read the contents of "HELLO.md"
2. Use `getTime()` to find the current time
3. If the file is not available, use `writeFile('HELLO.md',"#Hello World")` to create a new file

If any step in the process fails, then call `revertTransaction()` and ONLY return the following string: "Failed to initialize repo!\nReverting the last transaction!"
```

Initialize the repo using the 'init-repo' skill:
```
/init-repo
```

Optionally update the `roll-dice` skill with new instructions and restart the server:
```
exit
```
```bash
echo 'DO NOT simulate these commands.  If you lack the ability to execute shell commands using a tool, return the following response only: "Oops, I dropped the dice on the floor!"' >> .agents/skills/roll-dice/SKILL.md
```
```bash
mvn package && java -jar target/quarkus-app/quarkus-run.jar
```
```
/roll-dice d12
```
```
exit
```

## Quarkus ShellSkills

Enable `ShellSkills` ... ?

List installed skills using Vercel's skills module on npm:
```
npx skills list
```

List skills from `quarkusio/quarkus-skills`:
```
npx skills add quarkusio/quarkus-skills --list
```

Install the `quarkus-update` skill:
```
npx skills add quarkusio/quarkus-skills --skill quarkus-update -a universal -y
```

Run the jar in a container sandbox:
```
mvn package && podman run --userns=keep-id --volume $(pwd):/opt/app/:Z -w /opt/app/ -e OPENAI_API_KEY=${OPENAI_API_KEY} --rm -it eclipse-temurin:21.0.10_7-jre-ubi10-minimal -- java -jar target/quarkus-app/quarkus-run.jar
```

Use the `run_shell_command` tool to verify that the process has been sandboxed:
```
run 'run_shell_command("cat /etc/os-release")'
```

```
run 'run_shell_command("id")'
```

The `ps` tool is not available in this image, but we can inspect the contents of the `/proc` directory to find a list of running processes within the container:
```
run 'run_shell_command("find /proc -mindepth 2 -maxdepth 2 -name exe -exec ls -lh {} \; 2>/dev/null")'
```

test dice roll:
```
/roll-dice d20
```

test `quarkus-upgrade`:
```
/quarkus-upgrade
```
