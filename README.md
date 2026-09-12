# Spring Boot CRUD API

Simple Spring Boot CRUD API with PostgreSQL, Docker Compose, and pgAdmin.

## Requirements

* Docker
* Git

No Java or Maven installation is required when using Docker.

## Setup

Clone the repository:

```bash
git clone <repository-url>
cd <project-directory>
```

Create `.env` in the project root:

```env
POSTGRES_DB=spring_crud
POSTGRES_USER=postgres
POSTGRES_PASSWORD=change-me
```

## Run

### Ubuntu

```bash
docker compose up --build
```

### Windows

```powershell
docker compose up --build
```

The API will be available at:

```text
http://localhost:8080
```

pgAdmin:

```text
http://localhost:5050
```

## Stop

```bash
docker compose down
```

To remove the database volume and reset the database:

```bash
docker compose down -v
```

The database seed runs automatically when the PostgreSQL volume is created for the first time.

## Local Development Without Docker

Requires Java 21 and Maven.

### Ubuntu

```bash
./mvnw spring-boot:run
```

### Windows

```powershell
.\mvnw.cmd spring-boot:run
```
