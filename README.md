# Client Case Manager

## Technologies
- Java 11
- Spring Boot
- Spring Data

## Features

This is Restful Web Service application for Create, Read, Update Messages and client cases.

## How to install

To launch the application, please follow the steps below :
- git clone https://github.com/yassinedahmouch/client-case-manager.git
- cd client-case-manager
- Run the command : mvn clean install
- Launch the app with the command : mvn spring-boot:run

## Scenario documentation
- Step 1 create a new Message.
- Step 2 create a client case ( the message will be added to the case during the creation).
- Step 3 create another message and update the client case with this message.
- Step 4 update the client case with a reference.
- Step 5 get the client cases to retrieve the created case.