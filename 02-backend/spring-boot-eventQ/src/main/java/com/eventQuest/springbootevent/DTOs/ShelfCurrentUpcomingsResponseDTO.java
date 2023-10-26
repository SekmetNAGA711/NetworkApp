package com.eventQuest.springbootevent.DTOs;

import lombok.Data;

@Data
public class ShelfCurrentUpcomingsResponseDTO {
    private EventDTO event;
    private int daysLeft;
}

