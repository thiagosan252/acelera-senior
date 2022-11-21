# Build API

As configurações do banco de dados estão em application properties, para usar o banco local pelo docker, altere o "localhost" por "host.docker.internal"

Execute os comandos:

```sh
./gradlew bootjar
docker build --build-arg JAR_FILE="build/libs/*.jar" -t acelera/api-java .

docker run -p 8080:8080 myorg/myapp
``` 

# Build Front

Execute os comandos:

```sh
docker build -t acelera/front-angular . 
docker run -p 80:80 acelera/front-angular  
```