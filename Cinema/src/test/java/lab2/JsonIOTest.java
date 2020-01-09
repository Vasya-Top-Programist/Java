package lab2;

import lab2.io.JsonIO;
import lab2.model.Film;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Year;

public class JsonIOTest {

    private Film film;

    @BeforeTest
    public void init() {
        film = new Film("Інтерстелар", "США",
                Film.Genre.DRAMA, Year.of(2017), 210);
    }


    @Test
    public void toFileTest() {
        JsonIO<Film> jsonIO = new JsonIO<>(Film.class);
        File file = new File("JSON_test.txt");
        jsonIO.toFile(film, file);
    }

    @Test(dependsOnMethods = "toFileTest")
    public void fromFileTest() throws IOException {
        JsonIO<Film> jsonIO = new JsonIO<>(Film.class);
        File file = new File("JSON_test.txt");
        Assert.assertEquals(jsonIO.fromFile(file), film);
    }
}
