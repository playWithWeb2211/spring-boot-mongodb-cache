# spring-boot-mongodb-cache

**1. curl for PUT call**

curl --location --request PUT 'http://localhost:8085/book?objectId=667f9731b8a62f0c3039eb90&name=Fourth%20Book' \
--header 'Content-Type: application/json' \
--data '{
"author": "author7",
"publisher": "publisher8",
"edition": "edition9"
}'

**2. curl for POST call**

curl --location 'http://localhost:8085/book' \
--header 'Content-Type: application/json' \
--data '{
"name": "Second Book",
"category": "category2",
"author": "author2",
"publisher": "publisher2",
"edition": "edition2"
}'

**3. curl for GET call**
curl --location --request GET 'http://localhost:8085/book/667f967cb8a62f0c3039eb8e' \
--header 'Content-Type: application/json' \
--data '{
"author": "author6",
"publisher": "publisher6",
"edition": "edition6"
}'

**4. Curl for DELETE call**
   curl --location --request DELETE 'http://localhost:8085/book/667f9731b8a62f0c3039eb90' \
   --data ''