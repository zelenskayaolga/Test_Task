package ru.zelenskaya.olga.app;

import lombok.extern.slf4j.Slf4j;
import ru.zelenskaya.olga.app.impl.AverageServiceImpl;
import ru.zelenskaya.olga.app.impl.PercentileServiceImpl;
import ru.zelenskaya.olga.app.service.AverageService;
import ru.zelenskaya.olga.app.service.PercentileService;

import static ru.zelenskaya.olga.app.Constants.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        AverageService calculateAverageService = AverageServiceImpl.getInstance();
        long averageTimeInMinutes = calculateAverageService.calculateAverageTimeInFlight(PATH_TO_FILE);
        log.info("Average time in flight " + averageTimeInMinutes + " minutes");

        PercentileService percentileService = PercentileServiceImpl.getInstance();
        long percentileTimeInFlight = percentileService.getPercentileTimeInFlight(PERCENTILE, PATH_TO_FILE);
        log.info("Percentile is " + percentileTimeInFlight + " minutes");
    }
}
