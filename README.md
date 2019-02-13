# Spring Exercises
Sandbox for various Spring Boot projects used to explore building APIs

### **Simple CRUD Application**
---
The user will be able to create, read, update, and delete records of people from a single table.

:white_check_mark: **Step 1 - Display All People From the People Table on the Home Page** 
* A single table will be used to hold records of people.
* Each record of a person will include the following attributes:
  * first name
  * middle name
  * last name
  * birthday
  * favorite color
  * birth location
  * biological mother's name 
  * biological father's name
  * marital status
  * gender
  * vegetarian/vegan
* Use Thymeleaf to provide a UI for showing the user all the people records
* Each record should be shown in an individual row that only shows the users first and last name

:white_check_mark: **Step 2 - Add Bootstrap**
* Add Bootstrap to the project to improve the UX

**Step 3 - Add Pagination**
* Add pagination for showing all of the people records

:white_check_mark: **Step 4 - Add Ability to View All the Details of a Person**
* Add a button on each row to view the person details
* When the user clicks the view details button, the user navigates to a separate page to view the person details.

**Step 5 - Add Ability to Update Person Record**
* Add another button on each row to update the person details
* When the user clicks the view details button, the user navigates to a form to update the person's details.

**Step 6 - Change Person Attributes from String to Enums and Date**
* biological mother's name is shown as _UNKNOWN_ if empty or unknown
* biological father's name is shown as _UNKNOWN_ if empty or unknown
* Birthday should be a DATE
* Favorite color is an ENUM with values of popular colors
* Marital Status is an ENUM with values SINGLE, MARRIED, DIVORCED, WIDOWED
* Gender is an ENUM with values MALE, FEMALE, NON-BINARY, UNKNOWN, or REFUSED TO ANSWER
* Vegetarian/Vegan is a BOOLEAN that displays YES or NO

**Step 7 - Add Ability to Create a Person Record**
* Add a button at the top of the page for creating a person record
* When the user clicks the create person record button, the user navigates to a form to create a person record.

**Step 8 - Add Ability to Delete a Person Record**
* Add another button on each row to delete a person record
* When the user clicks the delete a person record, the user is prompted with a popup window to confirm the deletion.

**Step 9 - Add PostgreSQL**
* You should be able to start the app in some other mode and be able to connect to a PostgresSQL DB

**Step 10 - Add Validations to Person Attributes**
* Add validations for each person attribute
* Show appropriate errors when a validation is violated
