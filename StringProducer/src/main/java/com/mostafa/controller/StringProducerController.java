package com.mostafa.controller;

import com.mostafa.service.StringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/7/2023 5:06 PM
 */
@RestController
@RequestMapping("/producer")
public class StringProducerController {
    @Autowired
    private StringProducerService producerService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishFlatMessage(@PathVariable String message) {
        try {
            producerService.publishFlatMessageWithinTopic(message);
            return ResponseEntity.ok("Message published.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
