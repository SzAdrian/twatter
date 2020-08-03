package com.codecool.twatterspring;

import com.codecool.twatterspring.model.dto.TimelineTweetDTO;
import com.codecool.twatterspring.redis.Timeline;
import com.codecool.twatterspring.redis.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


@SpringBootApplication
@EnableSwagger2
public class TwatterSpringApplication {

    @Autowired
    TimelineRepository timelineRepository;

    public static void main(String[] args) {
        SpringApplication.run(TwatterSpringApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.ant("/api/**"))
            .build();
    }

    @Bean
    public CommandLineRunner init(){


        return (args) -> {

            TimelineTweetDTO timelineTweetDTO = TimelineTweetDTO.builder().id(1L).build();
            Timeline timelineTest = Timeline
                    .builder()
                    .userId(1L)
                    .homeTweetDTOS(Arrays.asList(timelineTweetDTO))
                    .build();

            timelineRepository.save(timelineTest);

        };

    }
}
