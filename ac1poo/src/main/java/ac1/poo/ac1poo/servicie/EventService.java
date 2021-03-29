package ac1.poo.ac1poo.servicie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ac1.poo.ac1poo.dto.EventDTO;
import ac1.poo.ac1poo.dto.EventInsertDTO;
import ac1.poo.ac1poo.entities.Event;
import ac1.poo.ac1poo.repository.EventRepository;
@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public Page<EventDTO> getClients(PageRequest pageRequest) {
        
        Page<Event> list = repo.find(pageRequest);

        return list.map( c -> new EventDTO(c));
    }

    public List<EventDTO> getEvent() {
        List<Event> list=eventRepository.findAll();
        return toDTOList(list);
    }

    private List<EventDTO> toDTOList(List<Event> list) {
        List<EventDTO> listDTO=new ArrayList<>();
        for(Event e : list){
            EventDTO dto = new EventDTO(e.getId(), e.getNome(), e.getLocal(), e.getDataFinal(), e.getDataInicial(), e.getHorarioInicial(), e.getHorarioFinal(), e.getEmail());
            listDTO.add(dto);
        }
        return listDTO;

    }


}
