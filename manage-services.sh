#!/bin/bash

stop_services() {
    # Kill the Spring Boot app process
    echo "Stopping Spring Boot application..."
    pkill -f 'java.*spring-boot:run'

    # Stop and remove all Docker containers
    echo "Stopping Docker containers..."
    docker-compose down
}

start_services() {
    # Start the Docker containers (MongoDB and Mongo Express)
    echo "Starting MongoDB and Mongo Express containers..."
    docker-compose up -d

    # Wait for MongoDB to be ready
    echo "Waiting for MongoDB to be ready..."
    sleep 10

    # Start the Spring Boot application
    echo "Starting Spring Boot application..."
    ./mvnw spring-boot:run
}

# Main logic
case "$1" in
  start)
    start_services
    ;;
  stop)
    stop_services
    ;;
  restart)
    stop_services
    sleep 2  # Allow a moment for everything to shut down
    start_services
    ;;
  *)
    echo "Usage: $0 {start|stop|restart}"
    exit 1
    ;;
esac
