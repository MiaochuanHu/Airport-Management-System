# HLHMS

- [Introduction](#introduction)
- [Enterprise structure](#enterprise-structure)
  * [User roles](#user-roles)
- [Application](#application)
  * [Skills](#skills)
  * [Structure](#structure)
  * [Work Flows](#work-flows)
- [UML Diagrams](#uml-diagrams)
  * [Class Diagram](#class-diagram)
  * [Usecase Diagram](#usecase-diagram)
- [Test User Accounts](#test-user-accounts)
  * [End](#end)

## Introduction
This is a modern airport management software. Integrating passenger interaction with the airport into one application. Not only does it provide passengers with access to flight information, but also airlines to modify flight information, airport ground staff to assign upcoming aircraft runs, etc.
## Enterprise structure
There are four main enterprises,** airports, airlines, government departments, and services.** 
In the airport section we provide an interface to the airport staff and a method for the control department of the flight. The creation of flights and the modification of information is the responsibility of the airline section, which also includes the provision of flight crew and check-in services. For government agencies, we have border control and police officers who are responsible for airport security and checking passenger information. Of course an airport is not without its service departments, and we provide store information and lounges for our users to view. Passengers will receive the appropriate email after purchasing the item. Of course passengers can check their boarding information and tickets.
### User roles
Ground crew, flight crew, check-in counters, ticket agents, store salesmen, lounge greeters and police officers. Passengers and pick-ups. In terms of control, we have airline administrators, airport administrators, system administrators, etc.

## Application

### Skills
Graphical desktop application developed based on **Java Swing**. Relying data on **Azure Mysql** server for secure and stable data management.

### Structure
The **MVC** architecture is used to achieve loose coupling, reusability, portability, and sustainable development of the system. The data connection layer is responsible for all operations on database information. The ui interface is elegant and succinct, and very user-friendly. The model layer specifies the structure and relationship of each object, which makes post-maintenance and code processing well-dependent.

### Work Flows
- Create Different Users
- Create Flight Company
- Create Flight
- Buy Tickets
- Assign Flight Terminal and runway
- Checked-in
- Security Check
- Immigrarion check
- Passenger Rest
- Shopping

## UML Diagrams

### Usecase Diagram
![Usecase](https://user-images.githubusercontent.com/23330402/206941059-954649ff-e3bb-4156-bbb6-d6dd735a2739.jpg)

### Class Diagram
![ClassDiagram](https://user-images.githubusercontent.com/23330402/206945825-73f98007-d8d1-4df1-a1a6-7900faf4d9c6.jpg)

### Sequence Diagram
![Sequence](https://user-images.githubusercontent.com/23330402/206941071-d2c8189c-1304-4710-87ad-61510612552c.jpg)


## Test User Accounts



### End
