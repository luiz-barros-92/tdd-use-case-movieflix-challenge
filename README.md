# TDD Movieflix Use Case Challenge
[DevSuperior](https://devsuperior.com.br/)

Implement the necessary features for the tests of the project to pass.

## Conceptual Model
![img](https://github.com/luiz-barros-92/assets/blob/main/challenges/tdd-movieflix/conceptual-model.png)
<br>

## System Use Cases
| Use Case | IN | OUT |
|-----|-----|-----|
| List Movies | Initial: None. | The system displays a paginated list of movies (title, subtitle, year, image), ordered alphabetically by title, and all the names of the available genres. |
| | The user (visitor or member) optionally selects a genre. | The system displays the updated list, restricting the movies only to the selected genre. |
| View Movie Details | The user (visitor or member) selects a movie. | The system displays the movie's title, subtitle, year, image, and synopsis. Additionally, it shows a list of the review texts for that movie along with the name of the user who made each review. |
| | The member user optionally enters a review text for the movie. | The system displays the updated data, including the new review made by the user. |
