package ac1.poo.ac1poo.servicie;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ac1.poo.ac1poo.dto.EventDTO;
import ac1.poo.ac1poo.entities.Event;
import ac1.poo.ac1poo.repository.EventRepository;
@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public Page<EventDTO> getEvents(PageRequest pageRequest) {
        
        Page<Event> list = repo.find(pageRequest);

        return list.map( c -> new EventDTO(c));
    }
    
    public EventDTO getEventById(Long id) {
        Optional<Event> op = repo.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente not found") );
        return new EventDTO(event);
    }
    
    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw
             new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

}
