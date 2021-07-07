# Rewards Service

## Requirements
- Java 11
- Maven 3.8.X

## Steps for running locally
From your favorite CLI:
```java
mvn spring-boot:run
```

## Testing
You can CURL using the following to test
```
curl --location --request POST 'http://localhost:8080/api/v1/rewards' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 100,
  "customerId": 1001,
  "amount": 120,
  "date": "2021-07-02"
}'
```
Or use Postman with the ```test.json``` file located in ```test\resources```