# Awesome Auto Complete
An autocomplete app to search countries

![Auto-complete](https://github.com/lohith511/auto-complete/blob/master/gifs/AutoComplete.gif)

###  Technologies
- Java 8
- Spring boot 1.5.3
- Thymeleaf 3.0.0
- jQuery 3.3.0

### Build from source
```sh
git clone git@github.com:lohith511/auto-complete.git
cd auto-complete
./gradlew clean build (suffix "-x test" to skip tests )
./gradlew bootrun
You can access the application at 127.0.0.1:8080
```

### Docker
Auto Complete is very easy to install and deploy in a Docker container.
By default, the Docker will expose port 8080, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
cd auto-complete
docker build -t lohith511/auto-complete .
```
This will create the Auto Complete image and pull in the necessary dependencies.

Once done, run the Docker image and map the port to whatever you wish on your host. In this example, we simply map port 8000 of the host to port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8080:8080 lohith511/auto-complete:latest
```

Verify the deployment by navigating to your server address in your preferred browser.

```sh
127.0.0.1:8080
```
### Testing

A docker image for testing is available [on docker hub](https://hub.docker.com/r/lohith511/auto-complete). It comes with ruby, the bundler dependencies, and all supported versions of zsh installed.

Pull the docker image with:
```sh
docker pull lohith511/auto-complete
```
Run the image with
```sh
docker run -d -p 8080:8080 lohith511/auto-complete:latest
```

As shorthand, if docker-compose is installed run below command from project's root direcroty to pull and run the image.
```sh
cd auto-complete
docker-compose up -d
```

### Troubleshotting
If you encounter port is already used while building from source. Change the port to any availale ones in
```sh
auto-complete/src/main/resources/application.yml#server.port
```


