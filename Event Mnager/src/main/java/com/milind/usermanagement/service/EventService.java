package com.milind.usermanagement.service;

import com.milind.usermanagement.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class EventService {
    private static HashMap<Long, Event> EventIdsToEvents = new HashMap<>();

    public void addEvent(Event event) {
        EventIdsToEvents.put(event.getEventId(), event);
    }

    public Boolean updateEvent(Event event) {
        if (EventIdsToEvents.containsKey(event.getEventId())) {
            EventIdsToEvents.put(event.getEventId(), event);
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteEventById(long id) {
        EventIdsToEvents.remove(id);
    }

    public List<Event> getAllEventsByDate() {
        List<Event> events = new ArrayList<>(EventIdsToEvents.values());
        return events;
    }
}
