# FactbookProject
Project to create an SQL database from CIA Factbook data

As of last update: 

Completed:  
Main country data table, which contains country code, region, country name, and the CIA history introduction.  
Major cities from the "Major urban areas - population" which falls under the "People and Society category."  
Border data  
Geography data  

In Process:  
People and Society data - mostly completed

## Process

This project takes world data provided by the CIA in 
[The World Factbook](https://www.cia.gov/library/publications/the-world-factbook/)
to create a relational database. The data is in the public domain and free for public use.
[Download the World Factbook](https://www.cia.gov/library/publications/download/)

The project uses files found in the .../factbook/geos/ folder with the "print_" prefix.
For example US data is taken from the file print_us.html  
All the "print" files are put in a separate folder and parsed from there.

## Build Tools

- Java 1.8
- Intellij IDEA
- Gradle

---

## Dependencies

- [jsoup](https://mvnrepository.com/artifact/org.jsoup/jsoup/1.11.3)
Used to parse HTML Factbook data downloaded from the CIA Factbook website   

- [MySQL JDBC Driver](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.13)
This project creates a MySQL database but should be easily configurable to work with any SQL database

---

## Author

Aleksandr Strizhevskiy, strizhevskiy@erudos.com

---
