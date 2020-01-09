package lab2;

import lab2.io.XmlIO;
import lab2.model.Film;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Year;

public class XmlIOTest {
    private Film film;

    @BeforeTest
    public void init() {
        film = new Film("Інтерстелар", "США",
                Film.Genre.DRAMA, Year.of(2017), 210);
    }

    @Test
    public void toFileTest() {
        XmlIO<Film> xmlIO = new XmlIO<>(Film.class);
        File file = new File("XML_test.txt");
        xmlIO.toFile(film, file);
    }

    @Test(dependsOnMethods = "toFileTest")
    public void fromFileTest() throws IOException {
        XmlIO<Film> xmlIO = new XmlIO<>(Film.class);
        File file = new File("XML_test.txt");
        Assert.assertEquals(xmlIO.fromFile(file), film);

    }

}
