package com.mostafa.controller;

import com.mostafa.dto.User;
import com.mostafa.service.JsonProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 11/7/2023 5:06 PM
 */
@RestController
@RequestMapping("/json-producer")
public class JsonProducerController {
    @Autowired
    private JsonProducerService producerService;

    @PostMapping
    public ResponseEntity<?> publishFlatMessage(@RequestBody User user) {
        try {
            producerService.publishUserData(user);
            return ResponseEntity.ok("User published.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
