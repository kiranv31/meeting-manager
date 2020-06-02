package com.resourcebooking.meetingrooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({"com.resourceboking.meetingrooms.entity", "com.resourceboking.meetingrooms.repository",
	"com.resourceboking.meetingrooms.service"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MeetingRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomsApplication.class, args);
	}

}
