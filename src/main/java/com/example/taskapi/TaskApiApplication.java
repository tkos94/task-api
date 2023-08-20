	package com.example.taskapi;

	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.autoconfigure.domain.EntityScan;
	import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

	@SpringBootApplication
	@EntityScan("com.example.taskapi.model")
	@EnableJpaRepositories("com.example.taskapi.repository")
	public class TaskApiApplication {
		public static void main(String[] args) {
			SpringApplication.run(TaskApiApplication.class, args);
		}
	}
