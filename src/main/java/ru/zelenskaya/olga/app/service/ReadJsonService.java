package ru.zelenskaya.olga.app.service;

import ru.zelenskaya.olga.app.model.ListOfTickets;

public interface ReadJsonService {
    ListOfTickets getListOfTickets(String nameFile);
}
