# sandbox_spring_projects
Sandbox for various Spring Boot projects used to explore building APIs

### Simple CRUD API
The user will be able to create, read, update, and delete records of people from a single PostgreSQL table.

**Step 1 - Details**
* A single table will be used to hold records of people.
* Each record of a person will include the following attributes:
  * first name
  * middle name
  * last name
  * birthday
* Use Thymeleaf to provide a UI for user input

**Step 2 - Details**
* Add for each person record a gender column
  * Genders can be male, female, and non-binary

**Step 3 - Details**
* Add pagination for showing all of the records of people
