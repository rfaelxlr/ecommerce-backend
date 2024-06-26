This project is a **backend** for a basic e-commerce application, built for learning purposes. It utilizes the following technologies:

* **Java 17:** The programming language for development.
* **Spring Boot 3.1.3:** A framework for rapid application development.
* **PostgreSQL:** The database management system for storing product, order, and other e-commerce data.
* **RabbitMQ (Optional):** A message broker for asynchronous communication (depending on your implementation).
* **Flyway:** A database migration tool for managing schema changes.

**Getting Started**

This project is intended for educational purposes. Here's a basic guide to running it locally:

1. **Prerequisites:**

   - **Java 17:** Download and install from the official Oracle website: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
   - **PostgreSQL:** Install a local instance of PostgreSQL: [https://www.postgresql.org/download/](https://www.postgresql.org/download/)
     Consider using a tool like pgAdmin for management: [https://www.pgadmin.org/download/](https://www.pgadmin.org/download/)
   - **RabbitMQ (Optional):** Install RabbitMQ if you plan to use it for asynchronous communication: [https://www.rabbitmq.com/docs/download](https://www.rabbitmq.com/docs/download)

2. **Database Setup:**

   - Configure the database connection details in `application.properties`.
   - Create a database for the project (e.g., `ecommerce_backend`).
   - (Optional) Run any necessary database migration scripts using Flyway.

3. **Project Setup:**

   - Clone the project repository.
   - Ensure you have a Java IDE (e.g., IntelliJ IDEA) configured for Spring Boot projects.
   - Import the project into your IDE.

4. **Run the Application:**

   - Run the main application class (usually `EcommerceApplication`). This will start the Spring Boot application and connect to the database.
