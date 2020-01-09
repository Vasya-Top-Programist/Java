package lab1.service;

import lab1.model.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ScheduleServiceTest {

    private List<Schedule> schedules;

    private Film film1;
    private Film film2;

    private Cinema cinema1;
    private Cinema cinema2;

    @BeforeTest
    public void init() {
        cinema1 = new Cinema("Жовтень", "м.Чернівці, вул. Університетська, 10");
        film1 = new Film("Інтерстелар", "США", Film.Genre.DRAMA, Year.of(2017), 210);

        cinema2 = new Cinema("Ефект", "м.Чернівці, вул.Героїі Майдану 184");
        film2 = new Film("Марсіанин", "США", Film.Genre.SCI_FI, Year.of(2018), 140);

        Schedule schedule1 = new Schedule.Builder()
                .setCinema(cinema1)
                .setFilm(film1)
                .setDateStart(LocalDate.of(2019, 11, 11))
                .setDateFinish(LocalDate.of(2020, 1, 1))
                .setHall(Schedule.Hall.NORMAL_3D)
                .setTicketPrice(80)
                .addTime(LocalTime.of(11, 10))
                .addTime(LocalTime.of(12, 40))
                .addTime(LocalTime.of(15, 20))
                .build();

        Schedule schedule2 = new Schedule.Builder()
                .setCinema(cinema2)
                .setFilm(film2)
                .setDateStart(LocalDate.of(2019, 11, 11))
                .setDateFinish(LocalDate.of(2020, 1, 1))
                .setHall(Schedule.Hall.BIG_3D)
                .setTicketPrice(75)
                .addTime(LocalTime.of(11, 10))
                .addTime(LocalTime.of(15, 20))
                .build();

        Schedule schedule3 = new Schedule.Builder()
                .setCinema(cinema1)
                .setFilm(film2)
                .setDateStart(LocalDate.of(2019, 11, 11))
                .setDateFinish(LocalDate.of(2020, 1, 1))
                .setHall(Schedule.Hall.BIG_3D)
                .setTicketPrice(75)
                .addTime(LocalTime.of(11, 10))
                .addTime(LocalTime.of(15, 20))
                .build();

        schedules = new ArrayList<>(Arrays.asList(schedule1, schedule2, schedule3));
    }

    @Test
    public void isTimeScheduleValidTest() {
        Assert.assertFalse(ScheduleService.isTimeScheduleCorrect(schedules.get(0)));
        Assert.assertTrue(ScheduleService.isTimeScheduleCorrect(schedules.get(1)));
    }

    @Test
    public void getMostPopularFilmTest() {
        Assert.assertEquals(ScheduleService.getMostPopularFilm(schedules),
                Optional.of(film2));
    }

    @Test
    public void getMostPopularFilmInCinema() {
        Assert.assertEquals(ScheduleService.getMostPopularInCinema(schedules,
                cinema1), Optional.of(film1));
        Assert.assertEquals(ScheduleService.getMostPopularInCinema(schedules,
                cinema2), Optional.of(film2));
    }

}
