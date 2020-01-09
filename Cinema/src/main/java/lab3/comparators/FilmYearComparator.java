package lab3.comparators;

import lab3.model.Film;

import java.util.Comparator;

public class FilmYearComparator implements Comparator<Film> {

    @Override
    public int compare(Film film1, Film film2) {
        return Integer.compare(film1.getYear().getValue(),
                film2.getYear().getValue());
    }
}
