package dev.hunter.runnerz.run;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Monday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(1),
                1,
                RunLocation.OUTDOOR));

        runs.add(new Run(2,
                "Wednesday afternoon Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(2),
                2,
                RunLocation.INDOOR));

    }
}
