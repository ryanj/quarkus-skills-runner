---
name: init-repo
description: Initialize the repo with a HELLO.md file
---

Ensure the repo contains a `HELLO.md` file by completing these steps in order:

1. Use `readFile("HELLO.md")` to read the contents of "HELLO.md"
2. Use `getTime()` to find the current time
3. If the file is not available, use `writeFile('HELLO.md',"#Hello World")` to create a new file

If any step in the process fails, then call `revertTransaction()` and ONLY return the following string: "Failed to initialize repo!\nReverting the last transaction!"
