package lab3.service;

import lab3.model.Schedule;
import lab3.model.Film;
import lab1.model.Cinema;

import java.util.*;
import java.time.Duration;
import java.util.stream.Collectors;

public class ScheduleService {

    /* unable to refactor it using streams*/
    public static boolean isTimeScheduleCorrect(Schedule schedule) {
        if(schedule.getTimeSchedule().size()<2) {
            return true;
        }
        for(int i=0; i<schedule.getTimeSchedule().size() - 1; i++) {
            if(Duration.between(schedule.getTimeSchedule().get(i),
                    schedule.getTimeSchedule().get(i+1)).toMinutes() < schedule.getFilm().getDuration()) {
                return false;
            }
        }
        return true;
    }

    public static Optional<Film> getMostPopularFilm(List<Schedule> schedules) {
        if(schedules.isEmpty()) return Optional.empty();

        HashMap<Film, Integer> filmsAndCount = new HashMap<Film, Integer>();
        schedules.stream()
                .forEach(schedule ->  {
                    filmsAndCount.computeIfPresent(schedule.getFilm(),
                            (film, count) -> count+schedule.getTimeSchedule().size());
                    filmsAndCount.putIfAbsent(schedule.getFilm(), schedule.getTimeSchedule().size());
                });

        return filmsAndCount
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

    public static Optional<Film> getMostPopularInCinema(List<Schedule> schedules, Cinema cinema) {
        return getMostPopularFilm(schedules.stream()
                .filter(schedule -> schedule.getCinema()==cinema)
                .collect(Collectors.toList()));
    }

}
