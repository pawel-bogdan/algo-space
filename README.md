# Algo space

## To run app execute below command in current directory
```bash
docker-compose up --build
```

## After execution of this command service is available through
localhost:8080

## And Mysql is available through
localhost:3306

### You can get API documentation by clicking on the link below
[API documentation](http://localhost:8080/swagger-ui.html)

### If you want to run app locally in intellij execute below command before start (it might take a while to start mysql, wait around 30 seconds)
```bash
docker run --name mysql -p 3306:3306 -e MYSQL_USER=algo_space -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_PASSWORD=pass -e MYSQL_DATABASE=algo_space -d mysql:8.0.30
```
#### After executing above command, you can get to mysql client by executing below command  
```bash
docker exec -it mysql mysql -u algo_space -p pass
```
