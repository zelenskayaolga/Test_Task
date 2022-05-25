package ru.zelenskaya.olga.app.service;

import ru.zelenskaya.olga.app.model.ListOfTickets;

import java.util.List;

public interface DurationService {
    List<Long> getAmountOfMinutesInFlight(ListOfTickets listOfTickets);
}
