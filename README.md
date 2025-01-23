# Book Inventory Management System

This project is a simple console-based Book Inventory Management System implemented in Java. It allows users to add, remove, update, and search for books in an inventory. The system uses Object-Oriented Programming (OOP) principles and includes unit tests to ensure functionality.

## Features

- **Add Book**: Add new books to the inventory with details like title, author, ISBN, price, and category.
- **Remove Book**: Remove books from the inventory using their ISBN.
- **Update Book**: Update the details of existing books in the inventory.
- **Search by Category**: Search for books based on their category.
- **View All Books**: Display all books in the inventory.
- **View All Categories**: Display all unique categories in the inventory.

## Design Patterns

- **Singleton Pattern**: Ensures that there is only one instance of the `Inventory` class throughout the application.

## Technologies Used

- **Java**: Core programming language.
- **JUnit 5**: For unit testing.

## Getting Started

1. **Clone the repository**:
    ```sh
    git clone https://github.com/AkshayMagar11/Book-Inventory-Management-System.git
    ```

2. **Build the project**:
    ```sh
    mvn clean install
    ```

3. **Run the application**:
    ```sh
    mvn exec:java -Dexec.mainClass="Main"
    ```
    
## Unit Tests

Run the unit tests to ensure the functionality of the inventory management system:
```sh
mvn test
```

## Contributors

- **Team Cloud Ninja**
  -  Akshay Magar
  -  Akhilesh Pratapwar
  -  Aishwarya Sahay

