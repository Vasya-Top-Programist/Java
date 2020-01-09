package lab2;

import lab2.io.TextIO;
import lab2.model.Film;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Year;

public class TextIOTest {

    private Film film;

    @BeforeTest
    public void init() {
        film = new Film("Інтерстелар", "США",
                Film.Genre.DRAMA, Year.of(2017), 210);
    }

    @Test
    public void toFileTest() throws IOException, IllegalAccessException {
        TextIO<Film> textIO = new TextIO<>(Film.class);
        File file = new File("Text_test.txt");
        textIO.toFile(film, file);
    }

    @Test(dependsOnMethods = "toFileTest")
    public void fromFileTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {
        TextIO<Film> textIO = new TextIO<>(Film.class);
        File file = new File("Text_test.txt");
        Assert.assertEquals(textIO.fromFile(file), film);
    }
}
