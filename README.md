# TDD Movieflix Use Case Challenge
[DevSuperior](https://devsuperior.com.br/)

Implement the necessary features for the tests of the project to pass.

## Conceptual Model
![img](https://github.com/luiz-barros-92/assets/blob/main/challenges/tdd-movieflix/conceptual-model.png)
<br>
<br>

## System Use Cases
| Use Case | IN | OUT |
|-----|-----|-----|
| List Movies | Initial: None. | The system displays a paginated list of movies (title, subtitle, year, image), ordered alphabetically by title, and all the names of the available genres. |
| | The user (visitor or member) optionally selects a genre. | The system displays the updated list, restricting the movies only to the selected genre. |
| View Movie Details | The user (visitor or member) selects a movie. | The system displays the movie's title, subtitle, year, image, and synopsis. Additionally, it shows a list of the review texts for that movie along with the name of the user who made each review. |
| | The member user optionally enters a review text for the movie. | The system displays the updated data, including the new review made by the user. |
<br>
<br>

## API Endpoint Access Control and Response Codes

| Endpoint | Method | Expected Status | User Role | Notes |
|-----|------|------|------|------|
| /genres | GET | 401 Unauthorized | none | Invalid token |
| /genres | GET | 200 OK | VISITOR | Returns all genres |
| /genres | GET | 200 OK | MEMBER | Returns all genres |
| /movies/{id} | GET | 401 Unauthorized | none | Invalid token |
| /movies/{id} | GET | 200 OK | VISITOR | Returns movie details |
| /movies/{id} | GET | 200 OK | MEMBER | Returns movie details |
| /movies/{id} | GET | 404 Not Found | VISITOR, MEMBER | Non-existent ID |
| /movies | GET | 401 Unauthorized | none | Invalid token |
| /movies | GET | 200 OK | VISITOR | Returns ordered movie page |
| /movies | GET | 200 OK | MEMBER | Returns ordered movie page |
| /movies?genreId={id} | GET | 200 OK | VISITOR, MEMBER | Ordered page filtered by genre |
| /reviews | POST | 401 Unauthorized | none | Invalid token |
| /reviews | POST | 403 Forbidden | VISITOR | Access denied |
| /reviews | POST | 201 Created | MEMBER | Valid data, object inserted |
| /reviews | POST | 422 Unprocessable Entity | MEMBER | Invalid data |
