package dev.hunter.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/runs")
    List<Run> findAll(){
        return runRepository.findAll();
    }
    @GetMapping("/runs/{id}")
    Optional<Run> findByRunId(@PathVariable Integer id){
        return runRepository.findByRunId(id);
    }
}
