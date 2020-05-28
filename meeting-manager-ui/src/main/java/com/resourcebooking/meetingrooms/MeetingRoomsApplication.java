package com.resourcebooking.meetingrooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MeetingRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomsApplication.class, args);
	}

}
