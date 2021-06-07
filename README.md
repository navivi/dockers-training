# dockers-training

Dockers Training is a simple web server that prints some configuration message.
It also shows a list of files in some directory and show content of specific files. 

# Examples

1. Landing Page
```
GET

http://localhost:8080/training/dockers

```

![image](https://user-images.githubusercontent.com/14746328/121020650-3bb43b80-c7a9-11eb-9c2d-30d4274ca92b.png)

Where 'Hello uuuuu' is taken from the configuration in [application.yaml](src/main/resources/application.yaml)

2. Files List
```
GET

http://localhost:8080/training/dockers/files

```

![image](https://user-images.githubusercontent.com/14746328/121021315-ef1d3000-c7a9-11eb-93bd-12a4b79ac036.png)

Where the list are files in the directory with the path as taken from the configuration in [application.yaml](src/main/resources/application.yaml)

3. File Content
```
GET

http://localhost:8080/training/dockers/files/hello.text

```

![image](https://user-images.githubusercontent.com/14746328/121021722-56d37b00-c7aa-11eb-868e-0dd5a835a17f.png)
# Prerequisites

dockers-training is a Java based application.  

You must have **maven** and **JDK-8** installed.


# Getting Started

To run dockers-training web server, first install using maven.

```
mvn install
```

Once BUILD-SUCCESS you can find uber jar under target/ directory.

Run the application using java command:

```
java -jar target/dockers-1.0-SNAPSHOT.jar 
```

# Next...
Create Dockerfile from base image: openjdk:8-slim

See: ..


