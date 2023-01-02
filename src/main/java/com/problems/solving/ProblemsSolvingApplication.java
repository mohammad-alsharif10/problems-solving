package com.problems.solving;

import com.problems.solving.service.ArrayProblems;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
@RequiredArgsConstructor
public class ProblemsSolvingApplication {

    private final ArrayProblems arrayProblems;

    public static void main(String[] args) {
        SpringApplication.run(ProblemsSolvingApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {

        };
    }

}
