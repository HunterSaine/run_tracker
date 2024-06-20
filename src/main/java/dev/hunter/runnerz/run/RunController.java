package dev.hunter.runnerz.run;

import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/runs/{id}")
//    Optional<Run> findByRunId(@PathVariable Integer id){
//        return runRepository.findByRunId(id);
//    }
//    @PostMapping("/runs")
//    void newRun(@RequestBody Run run){
//        runRepository.create(run);
//    }
//    @PutMapping("/runs/{id}")
//    void updateRun(@RequestBody Run run,@PathVariable Integer id){
//        runRepository.update(run,id);
//    }
//    @DeleteMapping("/runs/delete/{id}")
//    void deleteRun(@RequestBody @PathVariable Integer id){
//        runRepository.delete(id);
//    }
}
