package ac1.poo.ac1poo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ac1.poo.ac1poo.dto.EventDTO;
import ac1.poo.ac1poo.dto.EventInsertDTO;
import ac1.poo.ac1poo.servicie.EventService;
@RequestMapping ("/events")
@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvent(){
        List<EventDTO> list=eventService.getEvent();
        return ResponseEntity.ok(list); 
    }

    @PostMapping
    public ResponseEntity<EventDTO> salvar(@RequestBody EventInsertDTO insertDTO){
        EventDTO eventDTO = eventService.save(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(eventDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(eventDTO);
    }
    
}