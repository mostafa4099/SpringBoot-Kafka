package com.mostafa.controller;

import com.mostafa.model.User;
import com.mostafa.service.ProducerJsonService;
import com.mostafa.service.ProducerStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerController {

    /**
     * Inject ProducerStringService service to access its properties.
     */
//    @Autowired
//    private ProducerStringService producerStringService;

    /**
     * Inject ProducerJsonService service to access its properties.
     */
    @Autowired
    private ProducerJsonService producerJsonService;

    /**
     * Endpoint to create/publish new String message
     * @param string message
     * @return ResponseEntity with string message.
     */
//    @GetMapping("/string/publish")
//    public ResponseEntity<String> publishStringMessage(@RequestParam("message") String message){
//        producerStringService.sendMessage(message);
//        return ResponseEntity.ok("Message published!");
//    }

    /**
     * Endpoint to create/publish new json message With User java object
     * @param user java object
     * @return ResponseEntity with string message.
     */
    @PostMapping("/json/publish")
    public ResponseEntity<String> publishJsonMessage(@RequestBody User user){
        producerJsonService.sendMessage(user);
        return ResponseEntity.ok("Message published!");
    }
}
