package com.eventQuest.springbootevent.controller;


import com.eventQuest.springbootevent.DTOs.EventDTO;
import com.eventQuest.springbootevent.entity.Event;
import com.eventQuest.springbootevent.responseModel.ShelfCurrentUpcomingsResponse;
import com.eventQuest.springbootevent.service.EventService;
import com.eventQuest.springbootevent.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/events")

public class EventController {

    private EventService eventService;


    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/secure/currentupcomings")
    public List<ShelfCurrentUpcomingsResponse> currentUpcomings(@RequestHeader(value = "Authorization") String token)
            throws Exception
    {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return eventService.currentUpcomings(userEmail);
    }

    @GetMapping("/secure/currentcount/count")
    public int currentCount(@RequestHeader(value = "Authorization") String token) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return eventService.currentCount(userEmail);
    }

    @GetMapping("/secure/reservedticket/byuser")
    public Boolean ticketEventByUser(@RequestHeader (value = "Authorization") String token,
                                     @RequestParam Long eventId) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token,"\"sub\"");
        return eventService.ticketEventByUser(userEmail, eventId);
    }


    @PutMapping("/secure/ticket")
    public Event ticketEvent (@RequestHeader(value = "Authorization") String token,
                              @RequestParam Long eventId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        return eventService.ticketEvent(userEmail, eventId);
    }


    //can test and see if I can make this a delete function deleteMapping
    @PutMapping("/secure/return")
    public void returnEvent(@RequestHeader(value = "Authorization") String token,
                           @RequestParam Long eventId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        eventService.returnEvent(userEmail, eventId);
    }


    @PutMapping("/secure/renew/upcoming")
    public void renewUpcoming(@RequestHeader(value = "Authorization") String token,
                          @RequestParam Long eventId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        eventService.renewUpcoming(userEmail, eventId);
    }


    @GetMapping("/events/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
        EventDTO eventDto = eventService.getEventById(id);
        if (eventDto != null) {
            return new ResponseEntity<>(eventDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
