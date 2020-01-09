package lab2.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lab2.exceptions.FilmParsingException;
import lab2.io.adapters.YearDeserializer;
import lab2.io.adapters.YearSerializer;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public class Film {

    public enum Genre {
        HORROR,
        DRAMA,
        SCI_FI,
        THRILLER
    }
    private String title;

    private String country;

    private Genre genre;

    @JsonSerialize(using = YearSerializer.class)
    @JsonDeserialize(using = YearDeserializer.class)
    private Year year;

    private int duration;

    public Film() {}

    public Film(String title, String country, Genre genre, Year year, int duration) {
        this.title = title;
        this.country = country;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
    }

    public Film(String str, String delimiter) throws FilmParsingException {
        String[] fields = str.split(delimiter);

        if(fields.length != this.getClass().getDeclaredFields().length) {
            throw new FilmParsingException("Count of fields is incorrect");
        }

        try {
            title = fields[0];
            country = fields[1];
            genre = Genre.valueOf(fields[2]);
            year = Year.parse(fields[3]);
            duration = Integer.parseInt(fields[4]);
        } catch (Exception ex) {
            throw new FilmParsingException(ex.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", genre=" + genre +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return duration == film.duration &&
                Objects.equals(title, film.title) &&
                Objects.equals(country, film.country) &&
                genre == film.genre &&
                Objects.equals(year, film.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, country, genre, year, duration);
    }
}
