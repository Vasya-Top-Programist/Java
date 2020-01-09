package lab1.service;

import lab1.model.Schedule;
import lab1.model.Film;
import lab1.model.Cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.time.Duration;

public class ScheduleService {

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
        int maxCount = 0;
        Film mostPopular = null;

        for(Schedule schedule : schedules) {
            filmsAndCount.computeIfPresent(schedule.getFilm(), (film, count) ->
                    count+schedule.getTimeSchedule().size());

           filmsAndCount.putIfAbsent(schedule.getFilm(), schedule.getTimeSchedule().size());


           if(maxCount < filmsAndCount.get(schedule.getFilm())) {
               maxCount = filmsAndCount.get(schedule.getFilm());
               mostPopular = schedule.getFilm();
           }
        }
        if(mostPopular==null) return Optional.empty();
        return Optional.of(mostPopular);
    }

    public static Optional<Film> getMostPopularInCinema(List<Schedule> schedules, Cinema cinema) {
        List<Schedule> founded = new ArrayList<>();
        for(Schedule schedule : schedules) {
            if(schedule.getCinema()==cinema) {
                founded.add(schedule);
            }
        }
        return getMostPopularFilm(founded);
    }

}
