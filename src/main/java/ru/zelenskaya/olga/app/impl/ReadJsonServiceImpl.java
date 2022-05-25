package ru.zelenskaya.olga.app.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import ru.zelenskaya.olga.app.model.ListOfTickets;
import ru.zelenskaya.olga.app.service.ReadJsonService;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ReadJsonServiceImpl implements ReadJsonService {
    private static ReadJsonService instance;

    private ReadJsonServiceImpl() {
    }

    public static ReadJsonService getInstance() {
        if (instance == null) {
            instance = new ReadJsonServiceImpl();
        }
        return instance;
    }

    @Override
    public ListOfTickets getListOfTickets(String nameFile) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.readValue(new File(nameFile), ListOfTickets.class);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
