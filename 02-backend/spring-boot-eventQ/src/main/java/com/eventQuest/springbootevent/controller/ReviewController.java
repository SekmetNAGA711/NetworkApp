package com.eventQuest.springbootevent.controller;

import com.eventQuest.springbootevent.RequestModels.ReviewRequest;
import com.eventQuest.springbootevent.service.ReviewService;
import com.eventQuest.springbootevent.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")

public class ReviewController {


        private ReviewService reviewService;

        public ReviewController (ReviewService reviewService) {

            this.reviewService = reviewService;
        }


    @GetMapping("/secure/user/event")
    public Boolean reviewEventByUser(@RequestHeader(value="Authorization") String token,
                                    @RequestParam Long eventId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");

        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail, eventId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value="Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }



}


