package ru.zelenskaya.olga.app.impl;

import ru.zelenskaya.olga.app.model.ListOfTickets;
import ru.zelenskaya.olga.app.model.Ticket;
import ru.zelenskaya.olga.app.service.DurationService;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DurationServiceImpl implements DurationService {
    private static DurationService instance;

    private DurationServiceImpl() {
    }

    public static DurationService getInstance() {
        if (instance == null) {
            instance = new DurationServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Long> getAmountOfMinutesInFlight(ListOfTickets listOfTickets) {
        List<Ticket> tickets = listOfTickets.getTickets();
        List<Long> listOfMinutesInFlight = new ArrayList<>();
        for (Ticket ticket : tickets) {
            LocalTime departureTime = ticket.getDepartureTime();
            LocalTime arrivalTime = ticket.getArrivalTime();
            Duration duration = Duration.between(departureTime, arrivalTime);
            listOfMinutesInFlight.add(duration.toMinutes());
        }
        return listOfMinutesInFlight;
    }
}
