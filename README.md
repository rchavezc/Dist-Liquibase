# Distributed Liquibase

This software was born because we needed a way to use [Liquibase](http://www.liquibase.org/) in multiple ~~identical and distributed~~ databases.

## Problem and _Solution_

> Divide et impera

We had a main data base (as we all usually start) where we had all the clients information, but along with the system 
and the amount of clients growing, a single database with all the information was no longer the best choice, mostly 
because of the performance impact.

Our solution was to create an instance of the data base per client and create a different connection to each one in
order to maintain an _scope_ for each one of them. With this _solution_ we could have a "big client database" on a
separated server/container/whatever and it will not impact any other client.

## The Backfire

It seems to be a good idea, different data bases for each client, nice and _clean_ but then, the horror...
how are we going to manage all the different changes on the databases if Liquibase does not support multiple 
connections? Because [Liquibase](http://www.liquibase.org/) use a _liquibase.properties_ where you set all the different
variables and data for the Database that you are working on and change the file name for each time you have to connect
to a new one. That means that if you are going to use many databases, you will need as much properties files as the 
number of databases that you will modify. For us, that number was 250+ databases...

Well... after a lot of research, nobody seemed to have encounter such problem or maybe i didn't look until the 15th 
Google result page.

Anyway, we are developers... right? If there's no solution for what we need, we create it! With that in mind, we started
this basic idea of a simple _Distributed Liquibase Manager ~~FROM HELLL!~~_

## The Idea

This was a simple idea...

Load all the Databases information from a simple file (XML, CSV), create a table view where you can select or deselect 
each database and then iterate through each record, create a  Liquibase.properties file and run Liquibase.



