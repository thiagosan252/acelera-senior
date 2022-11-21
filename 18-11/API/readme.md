# Build docker image

Execute os comandos:

```sh
./gradlew bootjar
docker build --build-arg JAR_FILE="build/libs/*.jar" -t myorg/myapp .

docker run -p 8080:8080 myorg/myapp
``` 

- Lembrando que é necessário alterar os parametros de configuração do banco de dados antes de realizar o build do gradlew.


