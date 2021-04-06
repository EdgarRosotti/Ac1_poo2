package ac1.poo.ac1poo.servicie;


import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ac1.poo.ac1poo.dto.EventDTO;
import ac1.poo.ac1poo.dto.EventInsertDTO;
import ac1.poo.ac1poo.dto.EventUpdateDTO;
import ac1.poo.ac1poo.entities.Event;
import ac1.poo.ac1poo.repository.EventRepository;
@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String nome, String local, LocalDate dataInicial, String descricao) {
        Page<Event> list = repo.find(pageRequest, nome, local, dataInicial, descricao);
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

    public EventDTO update(Long id, EventUpdateDTO updateDTO) {
        try {
            Event entity = repo.getOne(id);
            entity.setDataInicial(updateDTO.getDataInicial());
            entity.setHorarioInicial(updateDTO.getHorarioInicial());
            entity.setEmail(updateDTO.getEmail());

            entity = repo.save(entity);

            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    public EventDTO salvar(EventInsertDTO insertDTO) {
        Event entity = new Event(insertDTO);
        entity = repo.save(entity);
        return new EventDTO(entity);
    }

}
