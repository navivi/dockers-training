# dockers-training

Dockers Training is a simple web server that prints some configuration message.
It also shows a list of files in some directory and show content of specific files. 

## Examples

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
## Prerequisites

dockers-training is a Java based application.  

You must have **docker enging**, **maven** and **JDK-8** installed.


## Getting Started

To run dockers-training web server, first install using maven.

```
mvn install
```

Once BUILD-SUCCESS you can find uber jar under target/ directory.

Build the image using docker command:

```
docker build --tag my-image-tag . 
```
Run the container using docker command:

```
docker run --name test -d  my-image-tag
```

You can inspect the container to get ip it was assigned with:
```
docker inspect test | grep IPAddress
            "SecondaryIPAddresses": null,
            "IPAddress": "172.17.0.2",
                    "IPAddress": "172.17.0.2",

```

And then try in the browser:

```
GET

http://172.17.0.2:8080/training/dockers
```

You can delete the container using:

```
docker rm -f test
```

And run it again by passing it environment variable:
```
docker run --name test -d  --env CONFIG_MESSAGE="My new message" my-image-tag
```

You can run the container again by mounting it some directory from the host:
```
docker run --name test -d -p 8888:8080 -v $(pwd)/files:/root --env LOG_LEVEL=DEBUG my-image-tag
```

## Next...
Create 2 stages dockers

See: ..


