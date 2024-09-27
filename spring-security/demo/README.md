# Spring Security
Updated as of July 2023
Based off of a guide found [here](https://www.danvega.dev/blog/2022/09/06/spring-security-jwt/), highly reccomend reading it to gain a better understanding of how this project was composed.

## If you just want to steal this code and integrate it into your project

### Requirements

- A Spring boot project with
    - Spring Web
    - Spring Data (optional)
    - Spring Boot DevTools (optional)
    - MySql Driver (optional)
 - A User model with (at least)
   - Username (email is okay, but it may become confusing as spring security uses terminology such as `name`, `username`)
   - Password
- A User Service with a `public User findByUsername(String username)` method (that works)

### Getting Started

1. Add The required dependencies to your POM

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
2. Copy the entire `security` package into your project
3. Update invalid imports (particularly to your `User` and `UserService`)
4. Add the following lines to your `application.properties`

        rsa.private-key=classpath:certs/private.pem
        rsa.public-key=classpath:certs/public.pem
3. Replicate the `certs` folder from `src/main/resources` (Generating your own keys is optional, there is a readme in the folder outlining the process)
4. Add the following class level annotation to your main spring file.

        @EnableConfigurationProperties(RsaKeyProperties.class)


## Importing the project

### Eclipse

Importing this project into eclipse is as easy as you would believe, just file->import->maven->existing maven project.

### Postman

Postman does allow you to export/import entire collections as json files, but they hide this (to encourage the use of their cloud sharing I think). 

You want to click the hamburger menu in the very top left of your postman, then click import, and import the file labeled "EXAMPLE_POSTMAN_COLLECTION".

## Testing the project

You should now be able to run same basic tests to see how the system works. 

Jump into your postman and run either of the "login" requests (This should automatically update your bearer token).

Then run the Identity Test and you should see some information in your eclipse console.

You can also try the role request, which should only succeed if your most recent login was the admin login.

And finally there is a basic rest resource test avaialable as well.

## Generating your own SSL Keys

There are instructions in src/main/java/resources/certs/readme.md explaining how to generate your own keys.