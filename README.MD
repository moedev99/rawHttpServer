# Simple HTTP Server

A lightweight, **raw** HTTP server built from scratch in Java (JDK 21) using Maven.  
This server reads and writes directly to the network socket, without using any higher-level HTTP libraries.  
It handles basic GET and POST requests, serves static files, and includes a cool feature — all designed to be easy to understand and extend.

---

## Features

- Handle **GET** requests
- Handle **POST** requests
- Serve static files (e.g., HTML, CSS, JS)
- [Mention your cool feature here briefly]

---

## Endpoints

Your simple HTTP server supports the following endpoints:

| Method | Path         | Description                              |
|--------|--------------|----------------------------------------|
| GET    | `/hello`     | Returns a greeting message              |
| POST   | `/welcome`   | Accepts data and returns a welcome response |
| GET    | `/index.html`| Serves a static HTML file               |

Requests to any other paths will respond with a `404 Not Found` error.

---

## Requirements

- Java JDK 21+
- Maven 3.6+

---

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/simple-httpserver.git
cd simple-httpserver
mvn clean package
java -cp target/simpleHttpServer-1.0-SNAPSHOT.jar com.httpServer.http.SimpleHttpServer

