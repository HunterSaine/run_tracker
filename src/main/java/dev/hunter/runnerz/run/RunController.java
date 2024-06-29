package dev.hunter.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/runs")
    void newRun(@RequestBody Run run) {
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/runs/update/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/runs/delete/{id}")
    void deleteRun(@RequestBody @PathVariable Integer id) {
        runRepository.delete(id);
    }

    @GetMapping("/runs")
    List<Run> findByLocation(@RequestParam String location) {
        return runRepository.findByLocation(location);
    }

    @GetMapping("/mainscreen")
    public String listRuns(Model theModel) {
        List<Run> runList = runRepository.findAll();
        theModel.addAttribute("runs", runList);
        return "mainscreen";
    }
}