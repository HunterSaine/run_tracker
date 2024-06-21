package dev.hunter.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping
    List<Run> findAll(){
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
        }
        return run.get();
    }
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
