package com.milind.usermanagement.controller;

import com.milind.usermanagement.model.Event;
import com.milind.usermanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/addEvent")
    public String addEvent(@RequestBody Event event) {
        eventService.addEvent(event);

        return "Evemt " + event.getEventName() + " added successfully";
    }

    @PostMapping("/updateEvent")
    public String updateEvent(@RequestBody Event event) {
        Boolean update = eventService.updateEvent(event);

        if (update) {
            return "Event " + event.getEventName() + " updated successfully";
        }
        else {
            return "No such event present";
        }
    }

    @PostMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventService.deleteEventById(id);

        return "Event deleted successfully";
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity< List<Event> > getAllEventsByDate() {
        List<Event> events = eventService.getAllEventsByDate();

        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
