package lab1.model;

import lab1.exceprions.ScheduleBuilderException;
import org.testng.annotations.BeforeTest;

import lab1.model.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.Arrays;

public class ScheduleBuilderTest {

    Cinema cinema;
    Film film;

    @BeforeTest
    public void init() {
        cinema = new Cinema("Жовтень", "м.Чернівці, вул. Університетська, 10");
        film = new Film("Інтерстелар", "США", Film.Genre.DRAMA, Year.of(2017), 210);
    }

    @Test
    public void BuilderTest() {
        Schedule schedule = new Schedule.Builder()
                .setCinema(cinema)
                .setFilm(film)
                .setHall(Schedule.Hall.NORMAL_3D)
                .setDateStart(LocalDate.of(2019, 11, 11))
                .setDateFinish(LocalDate.of(2020, 1, 1))
                .setTicketPrice(75)
                .addTime(LocalTime.of(8, 10))
                .addTime(LocalTime.of(15, 20))
                .build();

        Assert.assertEquals(schedule.getCinema(), cinema);
        Assert.assertEquals(schedule.getFilm(), film);
        Assert.assertEquals(schedule.getHall(), Schedule.Hall.NORMAL_3D);
        Assert.assertEquals(schedule.getDateFinish(), LocalDate.of(2020, 1,1));
        Assert.assertEquals(schedule.getDateStart(), LocalDate.of(2019, 11,11));
        Assert.assertEquals(schedule.getTicketPrice(), 75.0);
        Assert.assertEquals(schedule.getTimeSchedule(), Arrays.asList(LocalTime.of(8, 10),
                LocalTime.of(15,20)));

    }

    @Test(dataProvider = "builderErrorProvider", expectedExceptions = ScheduleBuilderException.class)
    public void builderErrorTest(Cinema cinema, Film film , Schedule.Hall hall,
                                 LocalDate dateStart, LocalDate dateFinish, double price) {
        new Schedule.Builder()
                .setCinema(cinema)
                .setFilm(film)
                .setHall(hall)
                .setDateFinish(dateFinish)
                .setDateStart(dateStart)
                .setTicketPrice(price)
                .build();
    }

    @DataProvider
    public Object[][] builderErrorProvider() {
        return new Object[][] {
                {null, film, null, LocalDate.of(2019, 1,1),
                        LocalDate.of(2020, 11, 11), 87},
                {cinema, film, Schedule.Hall.BIG, LocalDate.of(2020, 11, 11),
                        LocalDate.of(2019, 1, 1), -20}};
    }
}
