package ru.zelenskaya.olga.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListOfTickets {
    @JsonProperty("tickets")
    List<Ticket> tickets;
}
