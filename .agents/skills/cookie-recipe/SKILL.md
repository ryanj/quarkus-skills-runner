---
name: cookie-recipe
description: provide detailed advice on how to bake cookies using a recipe
---

If each of the steps are executed successfully, print the combined result of the output from each step.  DO NOT SIMULATE RESULTS! If you are unable to complete ANY step in the process using an available tool or skill on the first try, abort all previous instructions and return this single result instead: "Oops - baking is difficult! Let's ask for help"

<Steps>
<Step>

Generate a short announcement that a special cookie recipe is available via the 'cookie-recipe' SKILL!

Example: "Here's a classic chocolate chip cookie recipe, made for you using the 'cookie-recipe' skill:"

</Step>
<Step>
Provide the following cookie baking instructions without any modifications:

```
### Ingredients:
- 2 1/4 cups all-purpose flour
- 1/2 teaspoon baking soda
- 1 cup unsalted butter, softened
- 1/2 cup granulated sugar
- 1 cup packed brown sugar
- 1 teaspoon salt
- 2 teaspoons pure vanilla extract
- 2 large eggs
- 2 cups semi-sweet chocolate chips
- 1 cup chopped nuts (optional)

### Instructions:

1. **Preheat the Oven:**
   Preheat your oven to 350°F (175°C).

2. **Mix Dry Ingredients:**
   In a small bowl, mix the flour and baking soda. Set aside.

3. **Cream Butter and Sugars:**
   In a large mixing bowl, beat the softened butter, granulated sugar, brown sugar, and salt until creamy.

4. **Add Vanilla and Eggs:**
   Beat in the vanilla extract and eggs, one at a time, until well combined.

5. **Combine Dry and Wet Ingredients:**
   Gradually add the flour mixture to the wet mixture, mixing just until combined.

6. **Add Chocolate Chips (and Nuts):**
   Stir in the chocolate chips and nuts (if using).

7. **Scoop the Dough:**
   Drop rounded tablespoons of dough onto ungreased baking sheets, spacing them about 2 inches apart.

8. **Bake:**
   Bake in the preheated oven for 9 to 11 minutes, or until the edges are golden brown but the centers are still soft.

9. **Cool:**
   Remove from the oven and let the cookies cool on the baking sheets for a few minutes before transferring them to wire racks to cool completely.

```

</Step>

<Step>

Generate a short closing message for the user that includes an emoji

Example: "Are you ready to start making your own homemade chocolate chip cookies?"

</Step>
<Step>
use the `roll-dice` skill to roll a "d20"
</Step>
<Step>
use the `getTime` tool to display the current time
</Step>
<Step>
Execute the following shell command and print the result: `ls / | head -n 2`
</Step>
</Steps>
