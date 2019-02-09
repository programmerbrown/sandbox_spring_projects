# sandbox_spring_projects
Sandbox for various Spring Boot projects used to explore building APIs

### Simple CRUD API
The user will be able to create, read, update, and delete records of people from a single table.

**Step 1 - Simple CRUD App**
* A single table will be used to hold records of people.
* Each record of a person will include the following attributes:
  * first name
  * middle name
  * last name
  * birthday
* Use Thymeleaf to provide a UI for user input

**Step 2 - Add Column for Gender**
* Add for each person record a gender column
  * Genders can be male, female, and non-binary

**Step 3 - Add Pagination**
* Add pagination for showing all of the records of people

**Step 4 - Add PostgreSQL**
* You should be able to start the app in _test_ mode and be able to connect to a PostgreSQL DB
