# Spring-boot security basic login
_This project implements a basic user registration and login using spring-boot security._

### User Registry
Make this request: 

`[POST] /api/v1/users`
```json
{
  "email": "user@test.com",
  "password": "test",
  "name": "User"
}
```

### Login
Access the `localhost:8080/login` on browser and user the email and password registred.