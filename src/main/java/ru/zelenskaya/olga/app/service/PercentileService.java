package ru.zelenskaya.olga.app.service;

public interface PercentileService {
    long getPercentileTimeInFlight(int percentile, String nameFile);
}
