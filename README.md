## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
Program to play rounds of Rock, Paper, Scissors (https://en.wikipedia.org/wiki/Rock-paper-scissors).

## Technologies
Project is created with:
* Java version: 17
* Gradle
* NodeJS 16.14.2
* React

## Setup
Make sure to have Docker and NodeJS 16
1. To run this project, clone the repo locally using IDE:

```
https://gitlab.com/nataliia.mirosh/rockpaperscissors.git
```
or
```
https://github.com/NatashaMir/RockPaperScissors.git
```
2. Build project 
```
./gradlew build
```
3. Open terminal (Command Prompt) and go to the project folder
4. Run command
```
docker compose up --detach
```
5. Make sure that the container has started
6. In browser open Swagger page
```
http://localhost:8082/swagger-ui/index.html
```
