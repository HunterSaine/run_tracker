package dev.hunter.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.ILoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id,title,started_on,completed_on,miles,location FROM Run WHERE id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }
    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("select * from Run where location = :location")
                .param("location", location)
                .query(Run.class)
                .list();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO Run(id,title,started_on,completed_on,miles,location) values (?,?,?,?,?,?)")
                .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
                .update();
        Assert.state(updated == 1, "Failed to create run" + run.title());
    }

    public void update(Run run, Integer id) {
        var updated = jdbcClient.sql("update Run set title=?,started_on=?,completed_on=?,miles=?,location=? where id=?")
                .params(List.of(run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString(), id))
                .update();
        Assert.state(updated == 1, "Failed to delete run " + id);
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from Run where id = :id")
                .param("id", id)
                .update();
        Assert.state(updated == 1, "Failed to delete run " + id);
    }


}
