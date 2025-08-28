# Docker Compose Setup

This project now includes Docker Compose support with MySQL 9.4.0.

## How it works

- Spring Boot Docker Compose support automatically starts the MySQL container when the application runs
- No need to manually run `docker-compose up`
- The container will be stopped when the application shuts down

## Running the application

Simply run:

```bash
mvn spring-boot:run
```

Spring Boot will:

1. Automatically detect the `docker-compose.yml` file
2. Start the MySQL 9.4.0 container
3. Wait for it to be healthy
4. Configure the datasource connection automatically
5. Run Flyway migrations
6. Start the application

## Manual Docker Compose usage

If you prefer to manage Docker containers manually:

```bash
# Start containers
docker-compose up -d

# Stop containers  
docker-compose down

# View logs
docker-compose logs mysql
```

## Database Connection

- **Host**: localhost
- **Port**: 3306
- **Database**: movie_reservation
- **Username**: root
- **Password**: root