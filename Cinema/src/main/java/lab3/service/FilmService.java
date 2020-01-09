package lab3.service;

import lab3.model.Film;
import lab3.comparators.FilmYearComparator;

import java.util.List;
import java.util.stream.Collectors;

public class FilmService {

    public static List<Film> orderByYear(List<Film> films) {
        return films.stream()
                .sorted(new FilmYearComparator())
                .collect(Collectors.toList());
    }

    public static List<Film> orderByTitle(List<Film> films) {
        return films.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Film> findByTitle(List<Film> films, String title) {
        return films.stream()
                .filter(film -> film.getTitle().equals(title))
                .collect(Collectors.toList());
    }
}
