# ChatWeb with Socket

This project is a simple web chat application built using Spring Boot and WebSockets. It allows multiple users to join a chat room and exchange messages in real-time.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 11 or higher
- Maven 3.0.0 or higher
- IntelliJ IDEA (optional, for running the application directly from the IDE)

## Getting Started

To get a local copy up and running, follow these simple steps.

### Installation

1. **Clone the repository**

    ```sh
    git clone https://github.com/andreeo/chatweb-with-socket.git
    cd chatweb-with-socket
    ```

2. **Navigate to the project directory**

   Ensure you are in the root directory of the project where the `pom.xml` file is located.

    ```sh
    cd chatweb-with-socket
    ```

### Running the Application

You can run the application either using Maven or directly from IntelliJ IDEA.

#### Using Maven

1. **Run the application**

   Use the following command to start the Spring Boot application:

    ```sh
    mvn spring-boot:run
    ```

2. **Access the application**

   Once the application is running, open your web browser and navigate to:

    ```
    http://localhost:8080
    ```

#### Using IntelliJ IDEA

1. **Open the project**

   Open IntelliJ IDEA and select `File -> Open...`, then navigate to the `chatweb-with-socket` directory and open it.

2. **Run the application**

    - Locate the `ChatWebWithSocketApplication.java` file in the `src/main/java` directory.
    - Right-click on the `ChatWebWithSocketApplication` class and select `Run 'ChatWebWithSocketApplication'`.

3. **Access the application**

   Once the application is running, open your web browser and navigate to:

    ```
    http://localhost:8080
    ```

## Usage

1. Open the chat application in your browser.
2. Login with your username and password (data stored in a CSV file).
3. Start sending and receiving messages in real-time with other users.

## Project Structure

- `src/main/java`: Contains the main application code
- `src/main/resources`: Contains application configuration files and static resources

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building production-ready applications
- [WebSocket](https://www.websocket.org/) - Protocol for full-duplex communication channels over a single TCP connection

## Contributing

Contributions are what make the open-source community such an amazing place to be, learn, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Project Link: [https://github.com/andreeo/chatweb-with-socket](https://github.com/andreeo/chatweb-with-socket)
