# spring-boot-dockerize

How to Dockerize Spring Boot Application

# Build Docker Image

$ docker build -t spring-boot-docker.jar .

# Check Docker Image

$ docker image ls

# Run Docker Image

$ docker run -p 9090:8080 spring-boot-docker.jar

In the run command, we have specified that the port 8080 on the container should be mapped to the port 9090 on the Host
OS.

# List all containers (only IDs)

docker ps -aq

# List all containers

docker container ps

# List all active containers

docker container ls -a

# Stop all running containers

docker stop $(docker ps -aq)

# Stop a particular container

docker container stop <<container_id>>

# Start a container

docker container start <<container_id>>

# Remove all containers

docker rm $(docker ps -aq)

# Docker

docker inspect <Container_Id>

# Remove a particular container

docker container rm <<container_id>>

# To force delete it add -f before the container id

docker container rm -f <<container_id>>

# Remove multiple containers

docker container rm <<container_id_1>> <<container_id_2>>

# To force delete it add -f before the container id

docker container rm -f <<container_id_1>> <<container_id_2>>

# Create a container associated with the registry image.

docker run -d -p 5000:5000 --name registry registry:latest

# ========Image Commands========================

# List all images

docker image ls

# Remove all images

docker rmi $(docker images -q)

# Remove all unused images

docker image prune -a

# Remove a particular image

docker image rmi <<image_id>>

# To force delete it add -f before the image id.

docker image rmi -f <<image_id>>

# image will tag to push to DockerHub

docker tag spring-bootdocker.jar prk54989/spring-bootdocker.jar

# Image push to DockerHub

docker push prk54989/spring-bootdocker.jar

# Docker Image pull from DockerHub

docker pull prk54989/spring-bootdocker.jar

# run Docker image from DockerHub

docker run -p 9090:8080 prk54989/spring-bootdocker.jar

# Build and push Spring Boot Docker images using Maven plugin

-JRE set in Jenkins : Go to Jenkins -> Manage Jenkins -> Configure System -> Global properties Check the box '
Environment variables' and add the JAVA_HOME path

# Run Docker Image

docker run -p 9090:8080 spring-boot-docker.jar
In the run command, we have specified that the port 8080 on the container should be mapped to the port 9090 on the Host
OS.

# Run Docker Image With tagname

docker run -p 9090:8080 prk54989/spring-boot-docker.jar

# Create a tag TARGET_IMAGE that refers to SOURCE_IMAGE

docker tag SOURCE_IMAGE[:TAG] TARGET_IMAGE[:TAG]
docker tag spring-boot-docker.jar prk54989/spring-boot-docker.jar

# push your image to the registry that is Docker Hub

docker push prk54989/spring-boot-docker.jar

# To push a new tag to this repository:

docker push prk54989/spring-boot-docker.jar:tagname

# Docker Pull Command

docker pull prk54989/spring-boot-docker.jar

# Docker Command	Functionality

# Start Docker

systemctl start docker

# Build Docker Image name with tag as employee-producer

docker image build -t employee-producer .

# Run the image named employee-producer as a container in detached mode

docker container run -d employee-producer

# Run the image named employee-producer as a container in interactive mode

docker container run -it employee-producer

# Using the image employee-producer runs a container with name producer

docker container run --name producer -d employee-producer

# Show the logs of the container having the first two characters of its id as lb

docker container logs producer

# Run the image named employee-producer as a container in detached mode and also link the internal docker port 8080 to external docker port 8080

docker container run -p 8080:8080 -d employee-producer

# The docker exec command runs a new command in a running container. So here in the running docker container we are running the command /bin/sh

docker container exec -it producer /bin/sh

# Stop the container having the name as producer

docker container stop producer

# List the currently running containers

docker container ps

# Remove container having container id beginning with container id lb

docker container rm lb

# List all Docker Networks

docker network ls

# Create a new Docker Network

docker network create network <name>

# List all Docker Volumes

docker volume ls

# Remove Docker Volume

docker volume <volume name>

# Remove all Docker Volumes not being used by the containers

docker volume prune

# Get details of a particular Docker Volume

docker volume inspect <volume name>

# Start the docker services using the default docker compose file

docker-compose up

# stop the docker services mentioned in the default docker compose file

docker-compose up

# Initialize a docker swarm

docker swarm init

# Create a Driver of type overlay

docker network create --driver overlay <driver name>

# List all services in a docker swarm

docker service ls

# create a network named employee-mysql - MYSQL provides an image in dockerhub which we can run as container.

docker network create employee-mysql

# image provided by dockerhub to run as container. Also we will specify following when running the container

docker container run --name mysqldb --network employee-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -d
mysql:latest

a. name of the mysql container
a. What should be the password for MYSQL
b. We want to create the Database named bootdb.
c. specify the network employee-mysql on which this container should be created.
d. start the container in detached mode.

# let us check if container has started correctly using logs command.

docker container logs -f mysqldb

# exec command we can also inspect if the database named bootdb is created successfully.

docker container exec -it mysqldb bash
mysql -uroot -proot
show databases;
use bootdb;

# Build the docker image for the spring boot project

docker image build -t employee-jdbc.jar .

# run this as a container. Also we are running the container on the employee-mysql network.

docker container run --network employee-mysql --name employee-jdbc-container -p 8080:8080 -d employee-jdbc.jar

docker container logs -f 34 






