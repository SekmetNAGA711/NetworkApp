package com.eventQuest.springbootevent.DTOs;

import lombok.Data;

@Data
public class TicketDTO {
    private Long id;
    private String userEmail;
    private String issueDate;
    private String expirationDate;
    private Long eventId;
}

