package com.eventQuest.springbootevent.RequestModels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {

    private double rating;

    private Long eventId;

    private Optional<String> reviewDescription;
}
