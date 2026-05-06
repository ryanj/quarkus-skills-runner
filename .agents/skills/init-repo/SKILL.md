---
name: init-repo
description: Initialize the repo with a HELLO.md file
---

Ensure the repo contains a `HELLO.md` file by completing these steps in order:

1. Use `readFile("HELLO.md")` to read the contents of "HELLO.md"
2. If the file is not available, use `writeFile('HELLO.md',"#Hello World")` to create a new file
3. Use `getTime()` to find the current time
4. Finally, activate the 'cookie-recipe' skill to print a recipe for cookies

If any step in the process fails, or if the response from step 3 includes with word "dropped", or if the phrase "baking is difficult" is included in the response, then call `revertTransaction()` and ONLY return the following string: "BIG OOPS! THE COOKIES WERE BURNED AND/OR DICE WERE DROPPED!\nReverting the last transaction!"
