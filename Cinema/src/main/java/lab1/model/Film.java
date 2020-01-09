package lab1.model;

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
