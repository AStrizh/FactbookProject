# FactbookProject
Project to create an SQL database from CIA Factbook data

As of last updata it only parses HTML data and creates .txt files for all the countries.

## Process

This project takes world data provided by the CIA in 
[The World Factbook](https://www.cia.gov/library/publications/the-world-factbook/)
to create a relational database. The data is in the public domain and free for public use.
[Download the World Factbook](https://www.cia.gov/library/publications/download/)

The project uses files found in the .../factbook/geos/ folder with the "print_" prefix.
For example US data is taken from the file print_us.html 
All the "print" files are put in a separate folder and parsed from there.

## Requirements

- Java 1.8
- Built with Intellij IDEA but should work with any IDE

---

## Dependencies

- [jsoup](https://mvnrepository.com/artifact/org.jsoup/jsoup/1.11.3)
Used to parse HTML Factbook data downloaded from the CIA Factbook website   

- [MySQL JDBC Driver](https://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.6)
This project creates a MySQL database but should be easily configurable to work with any SQL database

---

## Author

Aleksandr Strizhevskiy, strizhevskiy@erudos.com

---
