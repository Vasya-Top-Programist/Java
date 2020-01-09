package lab4.model;

import lab1.exceprions.ScheduleBuilderException;
import lab1.model.Cinema;
import lab3.model.Film;
import lab4.validators.FilmStartDate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Schedule {

    public enum Hall {
        SMALL,
        SMALL_3D,
        NORMAL,
        NORMAL_3D,
        BIG,
        BIG_3D
    }
    
    @NotNull(message = "Field cinema can't be null")
    private Cinema cinema;
    @NotNull(message = "Field film can't be null")
    private Film film;

    @NotNull(message = "Please set the dateStart")
    /*дата початку фільму має бути в межах двох років*/
    @FilmStartDate(yearLimit = 2, message = "Max year limit = 2")
    private LocalDate dateStart;
    private LocalDate dateFinish;

    @Size(max = 24, message = "Count of seances should be less than 24")
    private List<LocalTime> timeSchedule = new ArrayList<>();

    @Min(value = 30, message = "Min ticket price = 30")
    @Max(value = 500, message = "Max ticket price = 800")
    private double ticketPrice;
    @NotNull (message = "Please set the type of hall")
    private Hall hall;

    @AssertTrue(message = "DateStart should be before dateFinish")
    private boolean isDateValid() {
        if(dateFinish == null)
            return true;
        if(dateFinish.isAfter(dateStart))
            return true;
        return false;
    }

    @AssertTrue(message = "TimeSchedule isn't valid")
    private boolean isTimeScheduleValid() {
        if(timeSchedule.size()<2) return true;
        for(int i=0; i< timeSchedule.size() - 1; i++) {
            if(Duration.between(timeSchedule.get(i),
                    timeSchedule.get(i+1)).toMinutes() < film.getDuration()) {
                return false;
            }
        }
        return true;
    }


    public Cinema getCinema() {
        return cinema;
    }

    public Film getFilm() {
        return film;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }


    public List<LocalTime> getTimeSchedule() {
        return timeSchedule;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Hall getHall() {
        return hall;
    }

    public void setDateFinish(LocalDate dateFinish) {
        if(dateFinish.isBefore(dateStart)) {
            throw new ScheduleBuilderException("DateFinish should be after dateStart");
        }
        this.dateFinish = dateFinish;
    }

    public void addTime(LocalTime time) {
        this.timeSchedule.add(time);
    }

    public static class Builder {
        private Schedule schedule;

        public Builder() {
            schedule = new Schedule();
        }

        public Builder setCinema(Cinema cinema) {
            schedule.cinema = cinema;
            return this;
        }

        public Builder setFilm(Film film) {
            schedule.film = film;
            return this;
        }

        public Builder setDateStart(LocalDate date) {
            schedule.dateStart = date;
            return this;
        }

        public Builder setDateFinish(LocalDate date) {
            schedule.dateFinish = date;
            return this;
        }

        public Builder addTime(LocalTime time) {
            schedule.timeSchedule.add(time);
            return this;
        }

        public Builder setHall(Hall hall) {
            schedule.hall = hall;
            return this;
        }

        public Builder setTicketPrice(double price) {
            schedule.ticketPrice = price;
            return this;
        }

        public Schedule build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Schedule>> constraintViolations = validator.validate(schedule);

            if(!constraintViolations.isEmpty()) {
                StringBuilder str = new StringBuilder();
                constraintViolations .forEach(constraint -> {
                    str.append(constraint.getPropertyPath())
                            .append(" : ")
                            .append(constraint.getMessage())
                            .append("\n");
                });
                throw new ScheduleBuilderException(str.toString());
            }

            return schedule;
        }
    }
}
