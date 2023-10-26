package com.eventQuest.springbootevent.DTOs;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequestDTO {
    private double rating;
    private Long eventId;
    private Optional<String> reviewDescription;
}

