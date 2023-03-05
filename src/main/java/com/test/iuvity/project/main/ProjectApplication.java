package com.test.iuvity.project.main;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.test.iuvity.project.service", "com.test.iuvity.project.controller"})
@EntityScan("com.test.iuvity.project.entity")
@EnableJpaRepositories("com.test.iuvity.project.repository")
@EnableEncryptableProperties
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
