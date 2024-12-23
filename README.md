# labseq

Implement a REST service, using Quarkus, returning a value from the labseq sequence with  a simple JavaScript web GUI to invoke the service.

The labseq – l(n) - sequence is defined as follows:

```
n=0 => l(0) = 0 
n=1 => l(1) = 1 
n=2 => l(2) = 0 
n=3 => l(3) = 1 
n>3 => l(n) = l(n-4) + l(n-3)
```

## Running the application in dev mode

You can run this application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```


## Endpoints available

### To test only the API
```
http://localhost:8080/labseq/{inputValue}
```


### To use the JavaScript web GUI to invoke the service
```
http://localhost:8080/quinoa
```


### REST API documentation – Open API format (Swagger)
```
http://localhost:8080/swagger
```