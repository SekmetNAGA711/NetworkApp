package com.eventQuest.springbootevent.DTOs;

import com.eventQuest.springbootevent.entity.Event;
import lombok.Data;



@Data
public class EventDTO {
    private Long id;
    private String title;
    private String sponsor;
    private String description;
    private int quantity;
    private int eventAvailable;
    private String category;
    private String img;


    public class DTOConverter {

        public static EventDTO convertToEventDTO(Event event) {
            EventDTO dto = new EventDTO();
            dto.setId(event.getId());
            dto.setTitle(event.getTitle());
            dto.setSponsor(event.getSponsor());
            dto.setDescription(event.getDescription());
            dto.setQuantity(event.getQuantity());
            dto.setEventAvailable(event.getEventAvailable());
            dto.setCategory(event.getCategory());
            dto.setImg(event.getImg());
            return dto;
        }


    }






}




















