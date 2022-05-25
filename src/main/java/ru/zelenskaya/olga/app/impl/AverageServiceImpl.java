package ru.zelenskaya.olga.app.impl;

import ru.zelenskaya.olga.app.model.ListOfTickets;
import ru.zelenskaya.olga.app.service.AverageService;
import ru.zelenskaya.olga.app.service.DurationService;
import ru.zelenskaya.olga.app.service.ReadJsonService;

import java.util.List;

public class AverageServiceImpl implements AverageService {
    private final ReadJsonService readJsonService = ReadJsonServiceImpl.getInstance();
    private final DurationService durationService = DurationServiceImpl.getInstance();
    private static AverageService instance;

    private AverageServiceImpl() {
    }

    public static AverageService getInstance() {
        if (instance == null) {
            instance = new AverageServiceImpl();
        }
        return instance;
    }

    @Override
    public long calculateAverageTimeInFlight(String nameFile) {
        ListOfTickets listOfTickets = readJsonService.getListOfTickets(nameFile);
        List<Long> listOfMinutesInFlight = durationService.getAmountOfMinutesInFlight(listOfTickets);
        long sum = 0;
        for (Long minutes : listOfMinutesInFlight) {
            sum += minutes;
        }
        return sum / listOfMinutesInFlight.size();
    }
}
