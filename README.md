# Movie Watchlist Application

## Overview
The **Movie Watchlist App** is a dynamic web application developed using the **Spring Boot Framework**. It allows users to manage a personalized list of movies they wish to watch. The application leverages the **H2 database** for data storage, **Spring Web**, and **Thymeleaf** for creating responsive and dynamic web pages.

## Features

- **Add Movies**: Users can add movies to their watchlist along with details such as:
  - Movie Name
  - IMDb Rating (fetched using an external API)
  - Priority
- **Update Priority**: Adjust the priority of movies to better organize the watchlist.
- **Add Comments**: Leave comments or notes about movies for future reference.
- **Upcoming Feature**: A delete feature will soon be added, enabling users to remove movies from the list once they are watched.

## Technology Stack

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf with dynamic HTML and CSS
- **Database**: H2 Database (in-memory database for development and testing)
- **External API**: IMDb API integration for fetching movie ratings

## How It Works

1. **Home Page**: Displays the user's movie watchlist with details like movie names, IMDb ratings, priority, and comments.
2. **Add Movie**: A form where users can add new movies to their watchlist.
3. **Update Priority**: Easily modify the priority of movies directly from the list.
4. **Comments Section**: Add comments to movies for personalized notes.

## Upcoming Features

- **Delete Movie**: Users will soon be able to delete a movie from their watchlist after watching it.

## Installation and Usage

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- IDE (Eclipse, IntelliJ IDEA, etc.)

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd movie-watchlist-app
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the application in your browser at:
   ```
   http://localhost:8080
   ```

## Screenshots (Optional)

_Add screenshots of your application for a better understanding of its features._

## Contributing

Contributions are welcome! If you have suggestions or want to add new features, feel free to:
- Fork the repository
- Create a new branch for your feature
- Submit a pull request

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

Enjoy managing your movie watchlist with ease!

