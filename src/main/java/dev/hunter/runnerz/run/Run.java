package dev.hunter.runnerz.run;

import javax.xml.stream.Location;

public record Run(Integer id, String title, String startTime, String endTime, Integer miles, Location location) {
}
