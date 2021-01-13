package com.sanshao.swagger2;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Swagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(Swagger2Application.class, args);
	}

}
