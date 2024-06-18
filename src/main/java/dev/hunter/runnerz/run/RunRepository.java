package dev.hunter.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }
    Optional<Run> findByRunId(Integer id) {
        return runs.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst();
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Monday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                1,
                RunLocation.OUTDOOR));

        runs.add(new Run(2,
                "Wednesday afternoon Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                2,
                RunLocation.INDOOR));

    }

    public void create(Run run) {
        runs.add(run);
    }
    public void update(Run run, Integer id) {
        Optional<Run> existingRun = findByRunId(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }
    public void delete(Integer id) {
        Optional<Run> existingRun = findByRunId(id);
        if (existingRun.isPresent()) {
            runs.remove(existingRun.get());
        }
    }
}
