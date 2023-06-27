# Trading Application
The Trading Application is receives trading signals, processes them using an algorithm, and performs trading actions based on the signals received.

## Features
* Receive trading signals via a RESTful API endpoint
* Process signals using an algorithm and Perform actions
* Flexible to accommodate additional actions and parameters
  
## Prerequisites
* Java 11 or higher
* Maven
* Git

The application will start running on the configured port. By default, it runs on port **8080** with the context path **'/tradingapp'**. You can modify the port and context path in the **'application.properties'** file.

## API Endpoint
The application exposes a RESTful API endpoint to receive trading signals:

**POST** **/tradingapp/signal** - Receive a trading signal and process it

### Example Request:
Content-Type: application/json

{
  "signalId": 1,
  "params": {
    "1": 60
  },
  "actions": [
    {"action": "setUp"},
    {"action": "performCalc"},
    {"action": "submitToMarket"}
  ]
}

### Example Response (Success):
HTTP/1.1 200 OK,
Content-Type: text/plain

Signal processed successfully

### Example Response (Error):
HTTP/1.1 500 Internal Server Error,
Content-Type: text/plain

Error processing the signal: <error-message>

## Swagger UI
The application utilizes Swagger UI to provide an interactive API documentation. You can access the Swagger UI at **'http://localhost:8080/tradingapp/swagger-ui/'** to explore the available endpoint and test them.

## Technologies Used
* Java 11
* Spring Boot
* Maven
* RESTful API

## Contact
For any inquiries or questions, please contact me
