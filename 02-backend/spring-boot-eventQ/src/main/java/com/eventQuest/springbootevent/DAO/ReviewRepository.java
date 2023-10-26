package com.eventQuest.springbootevent.DAO;

import com.eventQuest.springbootevent.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


public interface ReviewRepository extends  JpaRepository<Review, Long> {

    Page<Review> findByEventId(@RequestParam("event_id") Long eventId,
                              Pageable pageable);

    Review findByUserEmailAndEventId(String userEmail, Long eventId);


}
