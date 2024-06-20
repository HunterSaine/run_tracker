package dev.hunter.runnerz;

import dev.hunter.runnerz.run.RunLocation;
import dev.hunter.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {
    private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RunnerzApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            Run run = new Run(3,
//                    "first run",
//                    LocalDateTime.now(),
//                    LocalDateTime.now().plus(1, ChronoUnit.HOURS),
//                    1,
//                    RunLocation.INDOOR
//            );
//            log.info("Run: " + run);
//        };
//    }

}
