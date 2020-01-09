package lab1.model;

import lab1.exceprions.ScheduleBuilderException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    public enum Hall {
        SMALL,
        SMALL_3D,
        NORMAL,
        NORMAL_3D,
        BIG,
        BIG_3D
    }
    
    private Cinema cinema;
    private Film film;

    private LocalDate dateStart;
    private LocalDate dateFinish;

    private List<LocalTime> timeSchedule = new ArrayList<>();

    private double ticketPrice;
    private Hall hall;


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
            StringBuilder excMessage = new StringBuilder();

            if(schedule.film == null) excMessage.append("Field film can't be null\n");
            if(schedule.cinema == null) excMessage.append("Field cinema can't be null\n");
            if(schedule.hall == null) excMessage.append("Please set the hall\n");
            if(schedule.dateStart == null) excMessage.append("Please set the dateStart\n");
            if(schedule.ticketPrice <= 0) excMessage.append("Please input correct ticket price\n");

            if(schedule.dateFinish!=null &&
                    schedule.dateFinish.isBefore(schedule.dateStart)) {
                excMessage.append("dateFinish or dateStart isn't correct\n");
            }
            if(excMessage.length()!=0) {
                throw new ScheduleBuilderException(excMessage.toString());
            }

            return schedule;
        }
    }
}
