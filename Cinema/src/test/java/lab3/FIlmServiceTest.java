package lab3;

import lab3.model.Film;
import lab3.service.FilmService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIlmServiceTest {

    private Film film1;
    private Film film2;
    private Film film3;

    private List<Film> films;

    @BeforeTest
    public void init() {
        film1 = new Film("Інтерстелар", "США",
                Film.Genre.DRAMA, Year.of(2017), 210);

        film2 = new Film("Марсіанин", "США",
                Film.Genre.SCI_FI, Year.of(2018), 140);

        film3 = new Film("Марсіанин", "Німеччина",
                Film.Genre.HORROR, Year.of(1990), 80);

        films = new ArrayList<>(Arrays.asList(film1, film2, film3));
    }

    @Test
    public void orderByTitleTest() {
        Assert.assertEquals(FilmService.orderByTitle(films), Arrays.asList(film1, film2, film3));
    }

    @Test
    public void orderByYearTest() {
        Assert.assertEquals(FilmService.orderByYear(films), Arrays.asList(film3, film1, film2));
    }

    @Test
    public void findByTitleTest() {
        Assert.assertEquals(FilmService.findByTitle(films, "Марсіанин"),
                Arrays.asList(film2, film3));
    }
}
