# User account microservice

## Overview

    This application will give a list of accounts for given user. 
    The other endpoint will provide the lit of Transactions for a given account with link to go back to previes account list.
    
###Details

1. The application starts on Port 8080  
2. The application will have dummy DB creating using liquibase.
#####DB definition is in db.changelog-master.xml
#####DB insert script into inserts.sql

#### URLS 

-Below url is to get list of accounts for a given user

GET http://localhost:8080/account-service/api/accounts?userId={userId}

userId can be either of userId1 or userId2 for valid accounts



-Below url is to get list of transactions for given account

GET http://localhost:8080/account-service/api/accounts/{accountNum}/transactions

accountNum could be any account Id that we receive in previous response for a user.

####### response will also include ref link back to previous i.e. account link

Swagger-Docs

http://localhost:8080/account-service/v2/api-docs

Swagger-UI

http://localhost:8080/account-service/swagger-ui.html

   
    