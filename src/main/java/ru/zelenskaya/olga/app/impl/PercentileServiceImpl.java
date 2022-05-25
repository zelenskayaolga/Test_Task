package ru.zelenskaya.olga.app.impl;

import ru.zelenskaya.olga.app.model.ListOfTickets;
import ru.zelenskaya.olga.app.service.DurationService;
import ru.zelenskaya.olga.app.service.PercentileService;
import ru.zelenskaya.olga.app.service.ReadJsonService;

import java.util.List;
import java.util.stream.Collectors;

public class PercentileServiceImpl implements PercentileService {
    private final ReadJsonService readJsonService = ReadJsonServiceImpl.getInstance();
    private final DurationService durationService = DurationServiceImpl.getInstance();
    private static PercentileService instance;

    private PercentileServiceImpl() {
    }

    public static PercentileService getInstance() {
        if (instance == null) {
            instance = new PercentileServiceImpl();
        }
        return instance;
    }

    @Override
    public long getPercentileTimeInFlight(int percentile, String nameFile) {
        ListOfTickets listOfTickets = readJsonService.getListOfTickets(nameFile);
        List<Long> amountOfMinutesInFlight = durationService.getAmountOfMinutesInFlight(listOfTickets);
        List<Long> sortedList = amountOfMinutesInFlight
                .stream()
                .sorted()
                .collect(Collectors.toList());
        double coef = (double) percentile / 100 * sortedList.size();
        int index = (int) Math.ceil(coef);
        return sortedList.get(index);
    }
}
