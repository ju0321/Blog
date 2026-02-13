package com.web.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //created_at, updated_at 자동 업뎃
@SpringBootApplication
public class BlogApplication {

  public static void main(String[] args) {

    SpringApplication.run(BlogApplication.class, args);
  }

}
