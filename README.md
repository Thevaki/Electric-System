**Project Name**

_User Management System_ 

The service is implemented with Spring Boot, Maven, Hibernate and JPA.
Data was stored in a MySQL Database.
A REST endpoint was implemented to add users to the database.

**Functioanlities of the service**


_Create New Users_

curl --location --request POST 'http://localhost:8083/User/createUser' \
--header 'Content-Type: application/json' \
--data-raw '{
"surName": "Mathew",
"firstName": "Kevin",
"email": "kevin@gmail.com"
}'

_Find Users By SurName_

curl --location --request GET 'http://localhost:8083/User/findBySurName/Mathew'